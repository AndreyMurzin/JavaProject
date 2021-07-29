<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Для модификации семестра отредактируйте данный и нажмите кпопку "Применить"</h3>
<label>Длительность: </label>
<input type="text" value="${term.duration}">

<label>Дисциплины в семестре</label>
<select multiple class="multiple">
    <c:forEach items="${allDisciplines}" var="disc">
            <c:if test="${disc.selected}">
            <option selected>${disc.discipline}</option>
            </c:if>
        <c:if test="${not disc.selected}">
            <option>${disc.discipline}</option>
        </c:if>
    </c:forEach>
</select>

</body>
</html>
