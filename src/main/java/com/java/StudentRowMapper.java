package com.java;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student=new  Student();
		student.setId(rs.getInt("ID"));
		student.setName(rs.getString("NAME"));
		student.setEmail(rs.getString("EMAIL"));
		student.setPassword(rs.getString("PASSWORD"));
		student.setAddress(rs.getString("address"));
		
		return student;
	}

}
