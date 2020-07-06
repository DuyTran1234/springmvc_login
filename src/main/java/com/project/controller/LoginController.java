package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/dang-nhap")
	public String login(@RequestParam(name = "errors", required = false) String errors, HttpServletRequest request) {
		if(userService.checkAnonymousUser()) {
			request.setAttribute("errorsLogin", errors);
			return "LoginPage";
		}
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.isAuthenticated()) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			return "redirect:/dang-nhap";
		}
		return "redirect:/trang-chu";
	}
	
}
