package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.UserDTO;
import com.project.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminFeaturesController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/them-nguoi-dung")
	private String addUser(HttpServletRequest request) {
		request.setAttribute("addUser", new UserDTO());
		return "AdminAddUser";
	}
	
	@RequestMapping(value = "/add-user-controller", method = RequestMethod.POST)
	private String addUserController(@ModelAttribute("addUser") UserDTO userDTO) {
		userService.addUser(userDTO);
		return "redirect:/admin/danh-sach-nguoi-dung";
	}
	
	@RequestMapping(value = "/cap-nhat-nguoi-dung")
	private String updateUser(@RequestParam("id") int id, HttpServletRequest request) {
		request.setAttribute("updateUser", userService.getUserById(id));
		return "UpdateUser";
	}
	
	@RequestMapping(value = "/update-user-controller", method = RequestMethod.POST)
	public String updateUserController(@ModelAttribute("updateUser") UserDTO userDTO) {
		userService.updateUser(userDTO);
		return "redirect:/admin/danh-sach-nguoi-dung";
	}
	
	@RequestMapping(value = "/xoa-nguoi-dung")
	public String deleteUserController(@RequestParam("id") int id) {
		userService.deleteUser(id);
		return "redirect:/admin/danh-sach-nguoi-dung";
	}
	
	@RequestMapping(value = "/danh-sach-nguoi-dung")
	public String getAllUser(HttpServletRequest request) {
		request.setAttribute("listUser", userService.getAllUser());
		return "ListUser";
	}
}
