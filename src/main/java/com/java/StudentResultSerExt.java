package com.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentResultSerExt  implements ResultSetExtractor<List<Student>>{

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<Student>list=new ArrayList<Student>();
		
	while(rs.next()) {
		Student student=new Student();
		student.setId(rs.getInt("ID"));
		student.setName(rs.getString("NAME"));
		student.setEmail(rs.getString("EMAIL"));
		student.setPassword(rs.getString("PASSWORD"));
		student.setAddress(rs.getString("ADDRESS"));
		list.add(student);
	}

		
		
		
		return list;
	}

}
