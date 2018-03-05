<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professional Profile</title>
</head>
<body>

<h1>Hi <c:out value="${currentUser.name}"></c:out>!</h1>
<br>
<a href="/users">All Users</a>
<br>
<br>
<form id="logoutForm" method="POST" action="/logout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout!"/>
</form>
<br>

<h3>Here is your profile description:</h3>

<div style="width:250px; height:150px; overflow: auto;">
	<p><c:out value="${currentUser.description}"></c:out></p>
</div>

<h3>Your Professional Network:</h3>

<div style="width:200px; height:150px; overflow: auto;">
	<c:forEach var="friend" items="${currentUser.userFriends}">
		<a href="/users/${friend.id}"><c:out value="${friend.name}"/></a>
	</c:forEach>
</div>

<h3>Invitations:</h3>
<p>The following people asked you to be in their network:</p>


<table>
	<thead>
		<th>Name</th>
		<th>Action</th>
	</thead>
	<tbody>
	<c:forEach var="friend" items="${currentUser.requestingFriends}">
		<tr>
			<td><a href="/users/${friend.id}"><c:out value="${friend.name}"/></a></td>
			<td>
				<a href="/users/${friend.id}/accept/${currentUser.id}">Accept Invite</a> | 
				<a href="/users/${friend.id}/ignore/${currentUser.id}">Ignore</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>


</body>
</html>