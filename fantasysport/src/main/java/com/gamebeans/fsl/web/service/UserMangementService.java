package com.gamebeans.fsl.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamebeans.fsl.dao.UserDAO;
import com.gamebeans.fsl.dto.User;

@Service
public class UserMangementService 
{
	@Autowired
	private UserDAO dao;
	
	@Transactional
	public User getUserInfo(String emailId) {
		return dao.getUserInfo(emailId);
	}
	@Transactional
	public void saveUserInfo(User user)
	{
		dao.saveUser(user);
	}
	@Transactional
	public List<User> getAllUsers()
	{
		return dao.getAllUsers();
	}
	

}
