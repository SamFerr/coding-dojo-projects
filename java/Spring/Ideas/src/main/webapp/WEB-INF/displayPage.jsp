<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Like Status</title>
</head>
<body>

<a href="/bright_ideas">Bright Ideas</a>
<br>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>

<br>

<p><a href="/users/${currentIdea.creator.id}"><c:out value="${currentIdea.creator.name}"></c:out></a> says:</p>

<div style="width:350px; height:150px; overflow: auto;">
	<c:out value="${currentIdea.content}" />
</div>

<h2>People who liked this idea:</h2>

<table>
	<thead>
		<th>Alias</th>
		<th>Name</th>
	</thead>
	<tbody>
	<c:forEach var="user" items="${currentIdea.likers}">
		<tr>
			<td><a href="/users/${user.id}"><c:out value="${user.alias}" /></a></td>
			<td><c:out value="${user.name}" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>