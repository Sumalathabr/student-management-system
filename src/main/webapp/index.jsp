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
<title>Student List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f4f4f4;
    }
    .btn {
        display: inline-block;
        padding: 5px 10px;
        margin: 2px;
        color: #fff;
        text-decoration: none;
        border-radius: 4px;
    }
    .btn-edit {
        background-color: #4CAF50; 
    }
    .btn-delete {
        background-color: #f44336; 
    }
    .btn-add {
        background-color: #008CBA; 
        margin-bottom: 20px;
    }
</style>
</head>
<body>
<h1>Student List</h1>


<a href="addStudent.jsp" class="btn btn-add">Add Student</a>

<%
    StudentDAOimpl stdao = new StudentDAOimpl();
    List<Student> stlist = stdao.getAllStudents();
%>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <% 
            for(Student st : stlist) {
        %>
        <form>
            <tr>
                <td><%= st.getId() %></td>
                <td><%= st.getName() %></td>
                <td><%= st.getEmail() %></td>
                <td><%= st.getAge() %></td>
				
                <td>
                    <a href="editStudent.jsp?id=<%= st.getId() %>" class="btn btn-edit">Edit</a>
                    <a href="deleteStudent?id=<%= st.getId() %>" class="btn btn-delete">Delete</a>
                </td>
                
            </tr>
            </form>
        <% 
            } 
        %>
    </tbody>
</table>

</body>
</html>
