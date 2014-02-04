package net.webapp.services;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import net.webapp.domain.Topic;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph;

@Component
public class TopicService {
	@Autowired
	private GraphDatabaseService graphdb;
	private Neo4jGraph neo4jGraph;

	@PostConstruct
	public void init() {
		neo4jGraph = new Neo4jGraph(graphdb);
	}

	@Profile("test")
	@Bean
	public GraphDatabaseService graphdbTest() throws IOException {
		File tempFile = File.createTempFile("neo4j", "store");
		tempFile.delete();
		tempFile.mkdir();
		GraphDatabaseService graphDb = new GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder(tempFile.getCanonicalPath())
				.setConfig(GraphDatabaseSettings.nodestore_mapped_memory_size,
						"10M")
				.setConfig(GraphDatabaseSettings.string_block_size, "60")
				.setConfig(GraphDatabaseSettings.array_block_size, "300")
				.newGraphDatabase();
		return graphDb;
	}

	@PreAuthorize("isAuthenticated()")
	public void createTopic(Topic topic) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		try {
			Vertex topicVertex = neo4jGraph.addVertex(topic.getTitle());
			topicVertex.setProperty("title", topic.getTitle());
			Vertex userVertex = neo4jGraph.getVertex(user.getUsername());
			neo4jGraph.addEdge(null, userVertex, topicVertex, "authoredBy");
			neo4jGraph.commit();
		} catch (Throwable t) {
			neo4jGraph.rollback();
			throw new RuntimeException(t);
		}

	}
}
