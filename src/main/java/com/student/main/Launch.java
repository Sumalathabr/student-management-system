package com.student.main;

import java.util.List;

import com.student.DAOimpl.StudentDAOimpl;
import com.student.model.Student;

public class Launch {
	
	public static void main(String[] args) {
		Student st = new Student(24,"sumalatha","lsumagmail.com",21);
		StudentDAOimpl stdao=new StudentDAOimpl();
//		List<Student> stlist=stdao.getAllStudents();
//		System.out.println(stlist);
		
		//stdao.deleteStudent(1);
		stdao.updateStudent(st);
	}

}
