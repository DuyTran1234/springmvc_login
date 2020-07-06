package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.UserDTO;
import com.project.service.UserService;
import com.project.validator.UserValidator;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = "/dang-ky")
	public String registerForward(HttpServletRequest request) {
		if(!userService.checkAnonymousUser()) {
			return "HomePage";
		}
		request.setAttribute("registerUser", new UserDTO());
		return "RegisterPage";
	}
	
	@RequestMapping(value = "/register-controller", method = RequestMethod.POST)
	public String registerController(@ModelAttribute("registerUser") UserDTO userDTO, HttpServletRequest request,
			 BindingResult result) {
		if(!userService.checkAnonymousUser()) {
			return "HomePage";
		}
		userValidator.validate(userDTO, result);
		if(result.hasErrors()) {
			return "RegisterPage";
		}
		userService.addUser(userDTO);
		request.setAttribute("emailConfirm", userDTO.getEmail());
		return "AuthenticatePage";
	}
}
