package com.project.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.component.SendEmail;
import com.project.model.UserDTO;
import com.project.service.UserService;

@Controller
public class AuthenticateAccountController {
	@Autowired
	private SendEmail sendEmail;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/xac-thuc")
	public String authenticateForward() {
		return "AuthenticatePage";
	}
	
	@RequestMapping(value = "/send-email", method = RequestMethod.POST)
	public String sendEmail(@RequestParam(name = "email") String email, HttpSession session, 
			HttpServletRequest request) {
		if(userService.getUserByEmail(email) == null) {
			request.setAttribute("msgAuthenticate", "Unregistered mail");
			return "AuthenticatePage";
		}
		if(userService.getUserByEmail(email).getEnabled() == 1) {
			request.setAttribute("msgAuthenticate", "Email confirmed");
			return "AuthenticatePage";
		}
		int verificationCode = new Random().nextInt(999999 - 100000) + 100000;
		String content = "verification codes : "  + verificationCode;
		sendEmail.sendEmail("0985919093dd@gmail.com", email, "verification codes", content);
		session.setAttribute("verificationCodeSession", verificationCode);
		request.setAttribute("email", email);
		return "VerificationCodePage";
	}
	
	@RequestMapping(value = "/verification-code-controller", method = RequestMethod.POST)
	public String verificationCode(@RequestParam("verification-code") int code, HttpSession session, 
			HttpServletRequest request) {
		int verificationCode = (Integer) session.getAttribute("verificationCodeSession");
		if(verificationCode == code) {
			String email = request.getParameter("emailVerification");
			UserDTO userDTO = userService.getUserByEmail(email);
			if(userDTO.getEnabled() == 1) {
				request.setAttribute("msgAuthenticate", "Email confirmed");
				return "AuthenticatePage";
			}
			userDTO.setRole("ROLE_USER");
			userDTO.setEnabled(1);
			userService.updateUser(userDTO);
			session.removeAttribute("verificationCodeSession");
			return "LoginPage";
		}
		else {
			request.setAttribute("msgConfirm", "Wrong verification code!");
			return "VerificationCodePage";
		}
	}
}
