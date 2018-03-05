<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>

<a href="/bright_ideas">Bright Ideas</a>
<br>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>

<p>Name: <c:out value="${clickedUser.name}" /></p>
<p>Alias: <c:out value="${clickedUser.alias}" /> </p>
<p>Email: <c:out value="${clickedUser.username}" /></p>
<br>
<br>
<br>
<p>Total Number of Posts: <c:out value="${clickedUser.ideas.size() }"/></p>
<p>Total Number of Likes: <c:out value="${clickedUser.likedIdeas.size() }"/></p>

</body>
</html>