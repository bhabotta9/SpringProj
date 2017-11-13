package com.gamebeans.fsl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gamebeans.fsl.dto.User;
@Component
public interface UserDAO {
	public User getUserInfo(String emailId);
	public void saveUser(User user);
	public User updateUser(User user);
	public String deleteUser(String emailId);
	public List<User> getAllUsers();
}
