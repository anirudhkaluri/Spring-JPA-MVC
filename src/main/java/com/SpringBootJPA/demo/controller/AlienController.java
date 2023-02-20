package com.SpringBootJPA.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp"; //for this to return jsp we need to add tomcat jasper.
	}
	
}
