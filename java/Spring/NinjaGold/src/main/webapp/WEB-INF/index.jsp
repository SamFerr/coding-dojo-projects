<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body>

	<h1>Your Gold: <span class="border"><c:out value="${gold}"/></span></h1>
	
	<form action="/reset" method="get">
		<input type="submit" value="Reset Gold">
	</form>
	
	<h3>Farm</h3>
	<p>(Earns 10-20 gold)</p>
    <form action="/process" method="post">
     	<input type="hidden" name="building" value="farm" />
      	<input type="submit" value="Find Gold!"/>
     </form>
	
	<h3>Cave</h3>
	<p>(Earns 5-10 gold)</p>
    <form action="/process" method="post">
     	<input type="hidden" name="building" value="cave" />
      	<input type="submit" value="Find Gold!"/>
    </form>
	
	<h3>House</h3>
	<p>(Earns 2-5 gold)</p>
    <form action="/process" method="post">
     	<input type="hidden" name="building" value="house" />
      	<input type="submit" value="Find Gold!"/>
    </form>
	
	<h3>Casino</h3>
	<p>(Earns 0-50 gold)</p>
    <form action="/process" method="post">
     	<input type="hidden" name="building" value="casino" />
      	<input type="submit" value="Find Gold!"/>
    </form>
	
	<p>Activites</p>
	<c:forEach var="msg" items="${messages}">
		<c:choose>
			<c:when test="${msg.contains('lost')}">
				<p><c:out value="${msg}"/></p>
			</c:when>
		<c:otherwise>
			<p><c:out value="${msg}"/></p>
				</c:otherwise>
			</c:choose>
	</c:forEach>


</body>
</html>