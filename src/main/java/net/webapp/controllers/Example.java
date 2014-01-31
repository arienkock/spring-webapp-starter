package net.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class Example {
	@RequestMapping("/{id}")
	public String index(@PathVariable int id) {
		return "topic";
	}
}
