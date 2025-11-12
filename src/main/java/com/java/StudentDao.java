package com.java;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;


@Repository("studentDao")
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
//	create a Table
	
	public void GetCreateTable() {
		
		String str="create table student(id int,name varchar(100),email varchar(100),password varchar(100),address varchar(100))";
		
	jdbcTemplate.execute(str);
	
	System.out.println("create table  successfully................");
	
	}
	
	
	public DataSource getDataSource() {
		
		DataSource source=new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:xe", "system","1902");
		
		
		return source;
	}
	
	
//	Inserting values 
	
	public void getInsertingStudent(Student student) {
		
		String sql="insert into student values(?,?,?,?,?)";
		
		Object[]obj= {
				student.getId(),student.getName(),student.getEmail(),student.getPassword(),student.getAddress()
		};
		
		int x=jdbcTemplate.update(sql,obj);
		
		System.out.println("value inserting successfully............."+x);
	}
	
	
	
//	delete value
	public void getdeleteId(int id) {
		
		String sql="delete from student where id=?";
		int x=jdbcTemplate.update(sql,id);
		
		System.out.println("value deleted successfully..........."+x);
	}
	
	
//	update
	
	
	public void getUpdatedValue(String name,int id) {
		
		String sql="update student set name=? where id=?";
		Object[]obj= {
				name,id
		};
		int x=jdbcTemplate.update(sql,obj);
		
		System.out.println("values updated successfully........."+x);
		
	}

	
//	truncate table
	
	public void getTruncateTable() {
		
		String sql="truncate table student";
		
		int x=jdbcTemplate.update(sql);
		
		System.out.println("values truncate table successfully....."+x);
	}
	
	
	
//	Drop table
	
	
	public void getDropTable() {
		String sql="drop table student";
		
		int x=jdbcTemplate.update(sql);
		System.out.println("drop table successfully..........."+x);
	}
	
	
	
	public void getInsertingMultipleRecords(List<Student>students) {
		
		String sql="insert into student values(?,?,?,?,?)";
		List list=new ArrayList();
		
		
		for(Student student:students) {
			
			Object[] ob= {
					student.getId(),student.getName(),student.getEmail(),student.getPassword(),student.getAddress()
			};
			list.add(ob);
			
			int []x=jdbcTemplate.batchUpdate(sql,list);
			
			System.out.println("batchupdated successfully.........."+x);
			
		}
		
		
	}
	
	
	
	
	public List<Student>getAllStudents(){
		
		String sql="select * from student";
		
		List<Student>list=jdbcTemplate.query(sql, new StudentRowMapper());
		
		
		return list;
		
		
	}
	
	public List<Student>getSingleStudentValue(int id){
		
		String sql="select * from student where id=?";
		List<Student>list=jdbcTemplate.query(sql, new StudentResultSerExt(),id);
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
