<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/songs/new">Add New</a>
<a href="/search/topTen">Top Songs</a>

<form action="/search" method="POST">
	<input type="text" placeholder="Artist" name="artist"/>
	<input type="submit" value="Search Artists"/>
</form>

<table>
<c:forEach var="song" items="${songs}">
	<thead>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		<td><c:out value="${song.rating}"/></td>
		<td><a href="/songs/delete/${song.id}">Delete</a>
	</tbody>
</c:forEach>
</table>

</body>
</html>