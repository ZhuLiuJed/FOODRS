package com.dzh.foodrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dzh.foodrs.po.User;
import com.dzh.foodrs.repository.UserRepository;

@RestController
public class hellospringboot {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }
    
    @GetMapping("/test")
    public String test(){
    	User user = new User();
    	user.setUsername("test");
    	user.setPassword("123456");
    	userRepository.save(user);
    	return "ok";
    }
    
}
