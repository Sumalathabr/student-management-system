package com.student.DAO;

import java.util.List;

import com.student.model.Student;

public interface StudentDAO {
	
	
	int addStudent(Student s);
	List<Student> getAllStudents();
	int deleteStudent(int id);
	int updateStudent(Student s);
	Student getStudentById(int id);

}
