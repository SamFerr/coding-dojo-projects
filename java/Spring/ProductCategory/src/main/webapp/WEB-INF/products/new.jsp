<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>

<h1>New Proudct</h1>

	<form:form action="/products" method="POST" modelAttribute="product">
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name" />			
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input type="text" path="description" />			
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:input type="number" step="0.01" path="price" />			
		</p>			
		<input type="submit" value="Create"/>
	</form:form>

</body>
</html>