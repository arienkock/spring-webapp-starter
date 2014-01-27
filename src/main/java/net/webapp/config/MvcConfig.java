package net.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "net.webapp.controllers", "net.webapp.services" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	public static String[] resourcePatterns = new String[] { "/**/favicon.ico",
			"/js/**", "/css/**", "/images/**" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(resourcePatterns)
				.addResourceLocations("/css/", "/js/", "/images/")
				.setCachePeriod(31556926);
	}
}
