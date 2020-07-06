package com.project.service;

import java.util.List;

import com.project.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public void deleteUser(int id);
	public UserDTO getUserById(int id);
	public UserDTO getUserByUsername(String username, String password);
	public UserDTO getUserByUsername(String username);
	public UserDTO getUserByEmail(String email);
	public List<UserDTO> getAllUser();
	public boolean checkAnonymousUser();
	public String getUsernamePrincipal();
}
