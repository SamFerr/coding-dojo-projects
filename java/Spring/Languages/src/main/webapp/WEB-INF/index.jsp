<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
</head>
<body>

<table class="table">
<c:forEach items="${languages}" var="lang" varStatus="loop">
    <tr>    
    <td><a href="/languages/${loop.index}"></a><c:out value="${lang.language}"/></td>
    <td><c:out value="${lang.creator}"/></td>
    <td><c:out value="${lang.version}"/></td>
    <td><a href="/languages/delete/${loop.index}">Delete</a><td>
    <td><a href="/languages/edit/${loop.index}">Edit</a><td>
    </tr>
</c:forEach>
</table>
<br>

<form:form method="POST" action="/languages" modelAttribute="language">
	<form:label path="language">Name
	<form:errors path="language"/>
	<form:input path="language"/></form:label>
	
	<form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:input path="creator"/></form:label>
    
    <form:label path="version">Version
    <form:errors path="version"/>
    <form:input path="version"/></form:label>
    
    <input type="submit" value="Submit"/>

</form:form>

</body>
</html>