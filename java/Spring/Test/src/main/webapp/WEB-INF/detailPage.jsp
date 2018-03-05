<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>{clickedUser.name}</title>
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

<h1><c:out value="${clickedUser.name}" /></h1>

<h4>Description: <c:out value="${clickedUser.description}" /></h4>


</body>
</html>