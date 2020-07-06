package com.project.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.component.SendEmail;
import com.project.model.UserDTO;
import com.project.service.UserService;

@Controller
public class ResetPasswordController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendEmail sendEmail;
	
	@RequestMapping(value = "/lay-mat-khau")
	public String forgetPassword(HttpSession session) {
		if(!userService.checkAnonymousUser()) {
			return "HomePage";
		}
		return "ForgetPasswordPage";
	}
	
	@RequestMapping(value = "/send-email-password", method = RequestMethod.POST)
	public String sendEmailPassword(HttpServletRequest request, HttpSession session) {
		if(!userService.checkAnonymousUser()) {
			return "HomePage";
		}
		String email = request.getParameter("email");
		UserDTO userDTO = userService.getUserByEmail(email);
		if(userDTO == null) {
			request.setAttribute("msgForgetPassword", "Unregistered email");
			return "ForgetPasswordPage";
		}
		else if(userDTO.getEnabled() == 0) {
			request.setAttribute("msgForgetPassword", "Email is not activated");
			return "ForgetPasswordPage";
		}
		int verificationCode = new Random().nextInt(999999 - 100000) + 100000;
		String content = "Verification Code : " + verificationCode;
		this.sendEmail.sendEmail("0985919093dd@gmail.com", email, "Reset Password", content);
		session.setAttribute("resetPasswordSession", verificationCode);
		session.setAttribute("userResetPassword", userDTO);
		return "CodeResetPassword";
	}
	
	@RequestMapping(value = "/confirm-code-reset", method = RequestMethod.POST)
	public String confirmCodeResetPassword(HttpServletRequest request, HttpSession session) {
		int code = 0;
		try {
			code = Integer.valueOf(request.getParameter("code"));
		}
		catch(NumberFormatException e) {
			request.setAttribute("msgVerificationCode", "Errors Verification code");
			return "CodeResetPassword";
		}
		
		int verificationCode = (Integer) session.getAttribute("resetPasswordSession");
		if(code == verificationCode) {
			return "ResetPassword";
		}
		else {
			request.setAttribute("msgVerificationCode", "Errors Verification code");
			return "CodeResetPassword";
		}
	}
	
	@RequestMapping(value = "/reset-password-controller", method = RequestMethod.POST)
	public String resetPassword(HttpServletRequest request, HttpSession session) {
		String password = request.getParameter("new-password");
		UserDTO userDTO = (UserDTO) session.getAttribute("userResetPassword");
		userDTO.setPassword(password);
		userService.updateUser(userDTO);
		session.removeAttribute("resetPasswordSession");
		session.removeAttribute("userResetPassword");
		return "LoginPage";
	}
}
