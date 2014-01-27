package net.webapp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Example {
	@RequestMapping
	public String index(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.getWriter().println("ok");
		return null;
	}
}
