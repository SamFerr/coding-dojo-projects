<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>

<p>Songs by Artist: <c:out value="${song.artist}"/></p>

<form action="/search" method="POST">
	<input type="text" placeholder="Artist" name="artist"/>
	<input type="submit" value="New Search"/>
</form>

<a href="/dashboard">Dashboard</a>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<c:forEach var="song" items="${songs}">
			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			<td><c:out value="${song.rating}"/></td>
			<td><a href="/songs/delete/${song.id}">Delete</a></td>
		</c:forEach>
		</tr>
	</tbody>
</table>


</body>
</html>