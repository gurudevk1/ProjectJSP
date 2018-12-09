<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Films</title>
</head>
<body>
	<%@page import="com.guru.bean.Film,com.guru.dao.FilmDao,java.util.*"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	  
	<h1>Film List</h1>  
	  
	<%  
	List<Film> list=FilmDao.getAllRecords();  
	request.setAttribute("list",list);  
	%>  
	  
	<table border="1" width="90%">  
	<tr><th>Film Id</th><th>Film Name</th><th>Description</th><th>Release Year</th><th>Edit</th><th>Delete</th></tr>  
	<c:forEach items="${list}" var="u">  
	<tr><td>${u.getFilmId()}</td><td>${u.getTitle()}</td><td>${u.getDescription()}</td>  
	<td>${u.getReleaseYear()}</td><td><a href="editFilm.jsp?id=${u.getFilmId()}">Edit</a></td><td><a href="deleteFilm.jsp?id=${u.getFilmId()}">Delete</a></td></tr>  
	</c:forEach>  
	</table>  
	<br/><a href="addFilm.jsp">Add Film User</a>  
</body>
</html>