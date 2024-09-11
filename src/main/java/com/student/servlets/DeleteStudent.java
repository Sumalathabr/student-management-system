package com.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOimpl.StudentDAOimpl;

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAOimpl dimpl= new StudentDAOimpl();
		int id=Integer.parseInt(req.getParameter("id"));
		dimpl.deleteStudent(id);
		 resp.sendRedirect("index.jsp");
	}

}
