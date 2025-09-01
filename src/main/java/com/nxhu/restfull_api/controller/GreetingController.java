package com.nxhu.restfull_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello, World!";
	}
	
	@GetMapping("/sayHelloProtected")
	public String sayHelloProtected() {
		return "Hello, World Protected!";
	}
}
