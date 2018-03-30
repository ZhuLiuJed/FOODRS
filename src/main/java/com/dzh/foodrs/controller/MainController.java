package com.dzh.foodrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login(){
		return "sign_in";
	}
	
	@GetMapping("/myhtml")
	public String html(){
		return "MyHtml";
	}
}
