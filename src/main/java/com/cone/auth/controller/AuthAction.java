package com.cone.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthAction {
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

}
