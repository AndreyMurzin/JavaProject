<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/students.css">
</head>
<h1>Система управления студентами и их успеваемостью</h1>
<c:choose>
    <c:when test="${role ne null}">
        <a href="/logout">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/login">Login</a>
    </c:otherwise>
</c:choose>

<a href="">Студенты</a>
<a href="/terms">Семестры</a>
<a href="/disciplines">Дисциплины</a>
<a href="">Оценки</a>
</html>