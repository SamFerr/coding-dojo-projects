<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<h1>Hi, <c:out value="${currentUser.name}"></c:out>!</h1>

<form id="logoutForm" method="POST" action="/logout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout!"/>
</form>
<br></br>

	<form:form action="/create_idea" method="POST" modelAttribute="newIdea">
		<form:input type="hidden" path="creator" value="${currentUser.id}" />

		<form:label path="content" for="content"></form:label>
		<form:errors path="content" />
		<form:input path="content" value="Please Enlighten Us..."/>

   		<input type="submit" value="BAM!"/>
	</form:form>
    
    <c:forEach var="idea" items="${ideas}">
	   <div style="width:350px; height:100px; overflow: auto;">
	   	<p><a href="/users/${idea.creator.id}"><c:out value="${idea.creator.name}"></c:out></a> says: <c:out value="${idea.content}" /></p>
		<a href="/like/${idea.id}/${currentUser.id}">Like</a>
		<a href="/bright_ideas/${idea.id}"><c:out value="${idea.likers.size()}"/> like this.</a>
		</div>
	</c:forEach>

</body>
</html>