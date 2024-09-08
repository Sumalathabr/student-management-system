package com.student.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.DAO.StudentDAO;
import com.student.model.Student;
import com.student.utils.Connections;

public class StudentDAOimpl implements StudentDAO{
	
	
	private Connection con;
	private String ADD_STUDENT="insert into `student`(`name`, `email`, `age`) values(?,?,?)";
	private String GET_ALL_STUDENTS="select * from student";
	private String GET_STUDENT_BY_ID="select * from student where `id`=?";
	private String DELETE_STUDENT="delete from `student` where `id`=?";
	private String UPDATE_STUDENT="update student set `name`=?,`email`=?,`age`=?   where `id`=?";
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet set;

	public StudentDAOimpl() {
		// TODO Auto-generated constructor stub
		con=Connections.getConnection();
	}

	@Override
	public int addStudent(Student s) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			pstmt=con.prepareStatement(ADD_STUDENT);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getEmail());
			pstmt.setInt(3, s.getAge());
			
			res=pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> studentlist=null;
		try {
			stmt=con.createStatement();
			set=stmt.executeQuery(GET_ALL_STUDENTS);
			studentlist = new ArrayList();
			while(set.next())
			{
				studentlist.add(new Student(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentlist;
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			pstmt=con.prepareStatement(DELETE_STUDENT);
			pstmt.setInt(1, id);
			 res=pstmt.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			pstmt=con.prepareStatement(UPDATE_STUDENT);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getEmail());
			pstmt.setInt(3, s.getAge());
			pstmt.setInt(4, s.getId());
			res=pstmt.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Student getStudentById(int id) {
	    try {
	        pstmt = con.prepareStatement(GET_STUDENT_BY_ID);
	        pstmt.setInt(1, id);
	        ResultSet set = pstmt.executeQuery();
	        
	        if (set.next()) {
	            
	            return new Student(set.getInt("id"), set.getString("name"), set.getString("email"), set.getInt("age"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}

	
	

}
