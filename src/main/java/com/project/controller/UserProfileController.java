package com.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.component.SendEmailUsingThread;
import com.project.model.UserDTO;
import com.project.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserProfileController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendEmailUsingThread sendEmailUsingThread;
		
	@RequestMapping(value = "/profile")
	public String userProfile(HttpServletRequest request, HttpSession session) {
		return "UserProfile";
	}
	
	@RequestMapping(value = "/update-information-controller", method = RequestMethod.POST)
	public String updateUserInfomation(HttpSession session, HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) session.getAttribute("userSession");
		int id = userDTO.getId();
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userService.updateUser(userDTO);
		session.setAttribute("userSession", userService.getUserById(id));
		return "redirect:/user/profile";
	}
	
	@RequestMapping(value = "/update-avatar", method = RequestMethod.POST)
	public String updateUserAvatar(HttpSession session, HttpServletRequest request,
			@RequestParam("file-avatar") MultipartFile file) {
		UserDTO userDTO = (UserDTO) session.getAttribute("userSession");
		String fileName = new Date().getTime() + new Random().nextInt(1000) + file.getOriginalFilename();
		File fileUpload = new File("E:" + File.separator + "avatar" + File.separator + fileName);
		try {
			FileOutputStream fos = new FileOutputStream(fileUpload);
			fos.write(file.getBytes());
			fos.close();
			if(fileUpload.exists()) {
				userDTO.setAvatarUrl(fileName);
				userService.updateUser(userDTO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("userSession", userService.getUserById(userDTO.getId()));
		return "redirect:/user/profile";
	}
	
	@RequestMapping(value = "/send-code-change-email-controller")
	public String sendCodeChangeEmail(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		int verificationCode = new Random().nextInt(999999 - 100000) + 100000;
		String content = "Verification code change email: " + verificationCode;
		//sendEmail.sendEmail("0985919093dd@gmail.com", email, "Verification code", content);
		sendEmailUsingThread.setFrom("0985919093dd@gmail.com");
		sendEmailUsingThread.setTo(email);
		sendEmailUsingThread.setSubject("Verification code");
		sendEmailUsingThread.setContent(content);
		Thread thread = new Thread(sendEmailUsingThread);
		thread.start();
		
		session.setAttribute("codeChangeEmail", verificationCode);
		session.setAttribute("changeEmail", email);
		return "CodeChangeEmail";
	}
	
	@RequestMapping(value = "/update-email-controller", method = RequestMethod.POST)
	public String updateUserEmail(HttpSession session, HttpServletRequest request) {
		int verificationCode = (Integer) session.getAttribute("codeChangeEmail");
		int code = 0;
		try {
			code = Integer.valueOf(request.getParameter("code"));
		}
		catch(NumberFormatException e) {
			request.setAttribute("msgConfirmCode", "Wrong code, please enter again");
			return "redirect:/user/profile";
		}
		if(code == verificationCode) {
			String changeEmail = (String) session.getAttribute("changeEmail");
			UserDTO userDTO = (UserDTO) session.getAttribute("userSession");
			userDTO.setEmail(changeEmail);
			userService.updateUser(userDTO);
			session.removeAttribute("changeEmail");
			session.removeAttribute("codeChangeEmail");
			session.setAttribute("userSession", userService.getUserById(userDTO.getId()));
			return "redirect:/user/profile";
		}
		else {
			request.setAttribute("msgConfirmCode", "Wrong code, please enter again");
			return "redirect:/user/profile";
		}
	}
}
