package com.student.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOimpl.StudentDAOimpl;
import com.student.model.Student;


@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age =Integer.parseInt(req.getParameter("age"));
		
		Student s = new Student(id,name,email,age);
		StudentDAOimpl impl = new StudentDAOimpl();
		impl.updateStudent(s);
		resp.sendRedirect("index.jsp");
	}
	

}
