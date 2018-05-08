package com.dzh.foodrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login(){
		return "/login";
	}
	
	@GetMapping("/index")
	public String html(){
		return "/index";
	}
//	@GetMapping("/user/register")
//	public String register(){
//		return "/register";
//	}
//	@GetMapping("/user/registercheckuser")
//	public String registercheckuser(){
//		return "/registercheckuser";
//	}
}
