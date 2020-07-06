package com.project.dao;

import java.util.List;

import com.project.entity.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public User getUserByUsername(String username, String password);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	public List<User> getAllUser();
}
