package com.gamebeans.fsl.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamebeans.fsl.dto.User;

import com.gamebeans.fsl.web.service.UserMangementService;

@RestController
@RequestMapping("/user")
public class FslUserController {

	@Autowired
	UserMangementService service;

	@GetMapping("/userInfo")
	public User getUserInfo(HttpServletRequest request) {
		String emailId=request.getParameter("emailId");
		System.out.println("loginID  :"+emailId);
		return service.getUserInfo(emailId);
	}
	@PostMapping("save")
	public void saveUser(@RequestBody User user)
	{
		service.saveUserInfo(user);
	}
	@GetMapping("all")
	public @ResponseBody List<User> getAllUsers()
	{
		return service.getAllUsers();
	}

}
