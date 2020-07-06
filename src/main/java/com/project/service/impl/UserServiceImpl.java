package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.entity.User;
import com.project.model.UserDTO;
import com.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setEnabled(userDTO.getEnabled());
		user.setEmail(userDTO.getEmail());
		user.setAvatarUrl(userDTO.getAvatarUrl());
		userDao.addUser(user);
	}

	public void updateUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setEnabled(userDTO.getEnabled());
		user.setEmail(userDTO.getEmail());
		user.setAvatarUrl(userDTO.getAvatarUrl());
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public UserDTO getUserById(int id) {
		User user = userDao.getUserById(id);
		if(user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setEnabled(user.getEnabled());
		userDTO.setEmail(user.getEmail());
		userDTO.setAvatarUrl(user.getAvatarUrl());
		return userDTO;
	}

	public UserDTO getUserByUsername(String username, String password) {
		User user = userDao.getUserByUsername(username, password);
		if(user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setEnabled(user.getEnabled());
		userDTO.setEmail(user.getEmail());
		userDTO.setAvatarUrl(user.getAvatarUrl());
		return userDTO;
	}

	public UserDTO getUserByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		if(user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setEnabled(user.getEnabled());
		userDTO.setEmail(user.getEmail());
		userDTO.setAvatarUrl(user.getAvatarUrl());
		return userDTO;
	}

	public List<UserDTO> getAllUser() {
		List<User> listUser = userDao.getAllUser();
		if(listUser == null) {
			return null;
		}
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for(User user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setPhone(user.getPhone());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
			userDTO.setEnabled(user.getEnabled());
			userDTO.setEmail(user.getEmail());
			userDTO.setAvatarUrl(user.getAvatarUrl());
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}
	
	public UserDTO getUserByEmail(String email) {
		User user = userDao.getUserByEmail(email);
		if(user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setEnabled(user.getEnabled());
		userDTO.setEmail(user.getEmail());
		userDTO.setAvatarUrl(user.getAvatarUrl());
		return userDTO;
	}

	public boolean checkAnonymousUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if(principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		else {
			username = principal.toString();
		}
		if(username.equals("anonymousUser")) {
			return true;
		}
		return false;
	}

	public String getUsernamePrincipal() {
		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if(pricipal instanceof UserDetails) {
			username = ((UserDetails) pricipal).getUsername();
		}
		else {
			username = pricipal.toString();
		}
		return username;
	}
}
