<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="java.util.List" %>
<%@ page import="com.student.DAO.StudentDAO" %>
<%@ page import="com.student.DAOimpl.StudentDAOimpl" %>
<%@ page import="com.student.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f2f5; /* Light gray background */
        color: #333;
    }
    .container {
        max-width: 500px;
        margin: 40px auto;
        padding: 30px;
        background: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333; /* Dark gray for the heading */
        margin-bottom: 20px;
        font-size: 24px;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-bottom: 8px;
        font-weight: bold;
        color: #555; /* Slightly lighter gray for labels */
    }
    input[type="text"], input[type="number"], input[type="email"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc; /* Light gray border */
        border-radius: 4px;
        box-sizing: border-box;
    }
    button {
        width: 100%;
        padding: 12px;
        background-color: #4CAF50; /* Green */
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #45a049; /* Darker Green */
    }
</style>
</head>
<body>
<div class="container">
    <h1>Edit Student</h1>

    <% 
    StudentDAOimpl std = new StudentDAOimpl();
   int id = Integer.parseInt(request.getParameter("id"));
   Student s = std.getStudentById(id);
   
   if (s != null) {
%>
   <form action="editStudent" method="post">
       <input type="hidden" name="id" value="<%= s.getId() %>">

       <label for="name">Name:</label>
       <input type="text" id="name" name="name" value="<%= s.getName() %>">

       <label for="email">Email:</label>
       <input type="email" id="email" name="email" value="<%= s.getEmail() %>">

       <label for="age">Age:</label>
       <input type="number" id="age" name="age" value="<%= s.getAge() %>">

       <button type="submit">Save Changes</button>
       
   </form>
<% 
   } else { 
%>
   <p>Student with ID <%= id %> not found.</p>
<% 
   } 
%>
</div>
</body>
</html>
