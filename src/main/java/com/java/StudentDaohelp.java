package com.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentDaohelper")
public class StudentDaohelp {
	
	@Autowired
	private StudentDao dao;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	public void getSetupStudent() {
		
		Student student =new Student();
		
		student.setId(3);
		student.setName("zayn");
		student.setEmail("zayn@gmail.com");
		student.setPassword("zayn@123");
		student.setAddress("USA");
		
		
Student student2 =new Student();
		
		student2.setId(4);
		student2.setName("abhi");
		student2.setEmail("abhi@gmail.com");
		student2.setPassword("abhi@123");
		student2.setAddress("UK");
		
Student student3 =new Student();
		
		student3.setId(4);
		student3.setName("hariesh");
		student3.setEmail("hariesh@gmail.com");
		student3.setPassword("hariesh@123");
		student3.setAddress("hyd");
		
		List<Student>list=new ArrayList<Student>();
		list.add(student);
		list.add(student2);
		list.add(student3);
		
		
		dao.getInsertingMultipleRecords(list);
		
		
		
		
	}
	
	
	public void getPringvalues(List<Student>students) {
		
		
		for(Student student:students) {
			System.out.println(student);
		}
	}
	
	

}
