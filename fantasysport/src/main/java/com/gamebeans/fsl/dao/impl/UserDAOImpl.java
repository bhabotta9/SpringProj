package com.gamebeans.fsl.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.gamebeans.fsl.dao.UserDAO;
import com.gamebeans.fsl.dto.User;
import com.gamebeans.fsl.mapper.UserMapper;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public User getUserInfo(String emailId) {
		System.out.println(" User Info" + emailId);
		String qry = "select * from user_records where email=?";
		User user = (User) jdbc.queryForObject(qry, new Object[] { emailId }, new UserMapper());
		return user;
	}

	@Override
	public void saveUser(User user) {
		String qry = "Insert into user_records(email, mobile, fbid, gameid, active) values " + "('" + user.getEmailID()
				+ "','" + user.getMobileNumber() + "','" + user.getFacebookID() + "'," + user.getGameId() + "," + true
				+ ")";
		System.out.println("Query :" + qry);
		jdbc.execute(qry);

	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<>();
		String qry="Select * from user_records";
		List<Map<String, Object>> rows=jdbc.queryForList(qry);
		for(Map row:rows) {
			User user=new User();
			user.setId((Long)row.get("id"));
			user.setEmailID((String)row.get("email"));
			user.setFacebookID((String)row.get("fbid"));
			user.setMobileNumber((String)row.get("mobile"));
			users.add(user);
		}
		return users;
	}

}
