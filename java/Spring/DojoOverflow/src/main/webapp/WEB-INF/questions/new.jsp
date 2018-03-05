<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
</head>
<body>

<h1>What is your question?</h1>

<p class='error'><form:errors path="questionModel.*"/></p>

<form:form action="/questions" method="POST" modelAttribute="questionModel">
	<p>
		<form:label path="question">Question:</form:label>
		<form:input type="text" path="question" />			
	</p>
	<p>
		<form:label path="tags">Tags:</form:label>
		<form:input type="text" required="required" path="tags" />	
	</p>	
	<input type="submit" value="Create"/>
</form:form>

</body>
</html>