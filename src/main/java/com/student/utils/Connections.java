package com.student.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	
	private static Connection con=null;
	private static String url ="jdbc:mysql://localhost:3306/studentmanagement";
	private static String name="root";
	private static String pwd="Suma@123";
	
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pwd);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
