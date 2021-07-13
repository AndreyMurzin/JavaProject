<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Для того чтобы создать новую дисциплину
    заполните все поля и нажмите кнопку "Создать"</h1>

<label>Название</label>
<form action="/discipline-create" method="post">
    <input type="text" name="newDisc">
    <input type="submit" value="Создать">
</form>
<c:if test="${message == 'error'}">
    <h5>Поле не должно быть пустым!!!</h5>
</c:if>
</body>
</html>
