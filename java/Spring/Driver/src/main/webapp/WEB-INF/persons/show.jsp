<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
</head>
<body>

<h1><c:out value="${person.firstName}" /> <c:out value="${person.lastName}" /></h1>

<table>
			<tr>
				<td>License Number:</td>
				<td><c:out value="${person.license.number}" /></td>
			</tr>
			<tr>
				<td>State: </td>
				<td><c:out value="${person.license.state}" /></td>
			</tr>
			<tr>
				<td>Expiration Date</td>
				<td>
					<fmt:formatDate type="date" value="${person.license.expiration_date}" pattern="MM/dd/yyyy" />
				</td>
			</tr>
		</table>

</body>
</html>