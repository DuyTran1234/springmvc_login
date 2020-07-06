package com.project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.model.UserDTO;
import com.project.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		if(userDTO.getName().length() <= 0) {
			errors.rejectValue("name", "empty.name");
		}
		if(userDTO.getUsername().length() <= 0) {
			errors.rejectValue("username", "empty.username");
		}
		if(userDTO.getPassword().length() <= 0) {
			errors.rejectValue("username", "empty.password");
		}
		if(userDTO.getEmail().length() <= 0) {
			errors.rejectValue("email", "empty.email");
		}
		if(userService.getUserByUsername(userDTO.getUsername()) != null) {
			errors.rejectValue("username", "duplicate.user");
		}
		if(userService.getUserByEmail(userDTO.getEmail()) != null) {
			errors.rejectValue("email", "duplicate.email");
		}
	}
	
}
