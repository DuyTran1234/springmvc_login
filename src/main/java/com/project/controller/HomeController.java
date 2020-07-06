package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = {"/", "/trang-chu"})
	public String home(HttpSession session, HttpServletRequest request) {		
//		String username = userService.getUsernamePrincipal();
//		if(username.equals("anonymousUser")) {
//			return "HomePage";
//		}
//		else {
//			session.setAttribute("userSession", userService.getUserByUsername(username));
//			return "HomePage";
//		}
		return "HomePage";
	}
}
