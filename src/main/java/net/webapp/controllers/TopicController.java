package net.webapp.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/topic")
public class TopicController {
	@RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
	public String showTopic(WebRequest webRequest,
			HttpServletResponse response, @PathVariable int topicId) {
		long lastModified = System.currentTimeMillis() - 360000;
		if (webRequest.checkNotModified(lastModified)) {
			return null;
		}
		return "topic";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showAllTopics() {
		return "topic";
	}

	@RequestMapping(value = "/{topicId}", method = RequestMethod.PUT)
	public String updateTopic(@PathVariable int topicId) {
		return "topic";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createTopic(@PathVariable int topicId) {
		return "topic";
	}

	@RequestMapping(value = "/{topicId}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable int topicId) {
		return "topic";
	}
}
