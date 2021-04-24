package com.example.ecommerceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	@GetMapping("/v1/health")
	public String health() {
		return "OK";
	}
}
