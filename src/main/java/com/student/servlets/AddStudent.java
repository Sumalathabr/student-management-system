package com.student.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOimpl.StudentDAOimpl;
import com.student.model.Student;


@WebServlet("/addStudentServlet")
public class AddStudent extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int age =Integer.parseInt(req.getParameter("age"));
		Student s = new Student(name,email,age);
		StudentDAOimpl impl= new StudentDAOimpl();
		int res=impl.addStudent(s);
		if(res!=0)
		{
		resp.sendRedirect("index.jsp");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
	}

}
