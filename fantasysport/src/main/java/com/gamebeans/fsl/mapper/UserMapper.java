package com.gamebeans.fsl.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;

import com.gamebeans.fsl.dto.User;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException
	{
		User user = new User();
		System.out.println("mapRow() method");
		ResultSetMetaData metaData = resultSet.getMetaData();
		JSONObject rs = new JSONObject();
		
		try {
			System.out.println("Total Columns : " + metaData.getColumnCount());
			for(int i = 1; i <= metaData.getColumnCount(); i++) {
				String column = metaData.getColumnLabel(i);
				rs.put(column, resultSet.getString(column));
			}
			
			System.out.println("Output : " + rs.toString());
			user.fromJSONString(rs.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}