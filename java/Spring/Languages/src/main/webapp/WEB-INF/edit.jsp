<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Edit</title>
    </head>
    <body>
        <a href="/languages/delete/${id}">Delete</a>
        <a href="/">Dashboard</a>

        <p>
            <form:errors path="language.*" />
        </p>

        <form:form action="/languages/update/${id}" method="POST" modelAttribute="language">
            <form:hidden path="id"/>
            <p>
                <form:label path="language" for="language">Name</form:label>
                <form:input path="language" class="input-size float" type="text" name="language" />
            </p>
            <p>
                <form:label path="creator" for="creator">Creator</form:label>
                <form:input path="creator" class="input-size float" type="text" name="creator" />
            </p>
            <p>
                <form:label path="version" for="version">Version</form:label>
                <form:input path="version" class="input-size float" type="text" name="version" />
            </p>
            <input class="float" type="submit" value="Update" />
        </form:form>
    </body>
    </html>