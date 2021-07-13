<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Дисциплины</title>
    <link rel="stylesheet" href="../../resources/css/students.css?v=12">
    <script type="text/javascript" src="../../resources/js/function.js?v=12" charset="UTF-8"></script>
</head>
<body>
<h1>Страница с дисциплинами</h1>
<table>
    <tr>
        <td></td>
        <td>Название дисциплины</td>
    </tr>
    <c:forEach items="${disciplines}" var="disc">
        <tr>
            <td><input type="checkbox" value="${disc.id}"></td>
            <td>${disc.discipline}</td>
        </tr>
    </c:forEach>
</table>

<form action="/discipline-create" method="get">
    <input type="submit" value="Создать дисциплину ...">
</form>
<input type="submit" onclick="modifyDiscipline()" value="Модифицировать выбранную дисциплину ...">
<input onclick="deleteDisciplines()" type="submit" value="Удалить выбранные дисциплины ...">

<form id="formModify" action="/discipline-modify" method="get">
    <input type="hidden" id="hiddenModify" name="hiddenModify">
</form>

<form id="formDelete" action="/discipline-delete" method="post">
    <input type="hidden" id="hiddenDelete" name="hiddenDelete">
</form>

</body>
</html>
