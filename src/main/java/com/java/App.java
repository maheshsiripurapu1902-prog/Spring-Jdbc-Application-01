package com.java;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {

	  
	  ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
  
	  
	  StudentDaohelp help=context.getBean("StudentDaohelper",StudentDaohelp.class);
	  
	  StudentDao dao=(StudentDao)context.getBean("studentDao",StudentDao.class);
//	  dao.GetCreateTable();
	  
	  Student student=new  Student();
	  student.setId(1);
	  student.setName("zayn");
	  student.setEmail("zayn@gmail.com");
	  student.setPassword("zayn@123");
	  student.setAddress("vizag");
	  
//	  dao.getInsertingStudent(student);
	  
//	  dao.getdeleteId(1);
	  
	  
//	  dao.getUpdatedValue("mahesh", 1);
	  
//	  dao.getTruncateTable();
	  
//	  dao.getDropTable();
	  
//	  help.getSetupStudent();
//	  
//	  List<Student>list=dao.getAllStudents();
//	  help.getPringvalues(list);
	  
	  
	  List<Student>list=dao.getSingleStudentValue(3);
	  
	  help.getPringvalues(list);
	  
	  
	  
	  
	  
	  
	  
  
  }
}
