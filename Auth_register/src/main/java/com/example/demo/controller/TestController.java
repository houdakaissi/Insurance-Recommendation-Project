package com.example.demo.controller;


import com.example.demo.payload.response.HelooResponse;
import org.hibernate.jpa.boot.internal.Helper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	
	@GetMapping("/token")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content token.";
	}
	
	@GetMapping("/hello")
	//@PreAuthorize("hasRole('ADMIN')")
	public HelooResponse  usertest() {
		//return "hello from auth";
		return new HelooResponse("ggggggg");
	}
	
	@GetMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}

