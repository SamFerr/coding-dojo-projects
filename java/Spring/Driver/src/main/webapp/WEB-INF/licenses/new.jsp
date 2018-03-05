<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New License</title>
</head>
<body>

<h1>New License</h1>

<form:form action="/licenses/new" method="POST" modelAttribute="license">
			<p>
				<form:label path="person">Person:</form:label>
				<form:select path="person">
					<c:forEach items="${persons}" var="person">
						<form:option value="${person}" label="${person.firstName}  ${person.lastName}" />
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="state">State:</form:label>
				<form:input type="text" path="state" />			
			</p>
			<p>
				<form:label path="expiration_date">Expiration Date:</form:label>
				<form:input type="date" path="expiration_date" />		
			</p>
			<input type="submit" value="Create"/>
		</form:form>

</body>
</html>