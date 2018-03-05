<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users here</title>
</head>
<body>

<a href="/professional_profile">My Profile</a>
<br>
<br>
<form id="logoutForm" method="POST" action="/logout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout!"/>
</form>
<br>

<h1>Users you may want to connect with:</h1>

<table>
	<thead>
		<th>Name</th>
		<th>Action</th>
	</thead>
	<tbody>
	<c:forEach var="user" items="${allFriends}">
		<tr>
			<td><c:if test="${user != currentUser && !user.userFriends.contains(currentUser) && !user.requestingFriends.contains(currentUser)}"><a href="/users/${user.id}"><c:out value="${user.name}" /></a></c:if></td>
			<td>
				<c:if test="${user != currentUser && !user.userFriends.contains(currentUser) && !user.requestingFriends.contains(currentUser)}"><a href="/user/${user.id}/connect/${currentUser.id}">Connect</a></c:if>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>