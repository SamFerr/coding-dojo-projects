<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top 10 Babyyyy</title>
</head>
<body>

<a href="/dashboard">Dashboard</a>

<h1>Top 10 Songs</h1>

<ul>
<c:forEach var="song" items="${songs}">
<li>
	<c:out value="${song.rating}"/> - 
	<a href="/song/${song.id}"/><c:out value="${song.title}"/></a> - 
	<c:out value="${song.artist}"/>
</li>
</c:forEach>
</ul>
</body>
</html>