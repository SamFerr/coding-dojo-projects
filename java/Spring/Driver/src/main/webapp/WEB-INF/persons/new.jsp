<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Person</title>
</head>
<body>

<h1>New Person</h1>

<form:form method="POST" action="/persons/new" modelAttribute="person">
	<form:label path="firstName" for="firstName">First Name
	<form:errors path="firstName"/>
	<form:input path="firstName"/></form:label>
	
	<form:label path="lastName" for="lastName">Last Name
    <form:errors path="lastName"/>
    <form:input path="lastName"/></form:label>
    
    <input type="submit" value="Create"/>

</form:form>

</body>
</html>