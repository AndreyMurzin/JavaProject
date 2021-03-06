<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resoures/css/student-progress.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <script type="text/javascript" src="../../resoures/js/function.js?v=3" charset="UTF-8"></script>

    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    <title>Terms-list</title>
</head>

<body>

<section class="table_students">
    <div class="container">
        <ul class="nav nav-pills navbar">
            <li class="nav-item ">
                <a class="nav-link active home" aria-current="page" href="#">На главную</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link active exit" aria-current="page" href="#">Выход</a>
            </li>

        </ul>
        <h1>Система управления студентами и их успеваемостью</h1>

        <h3>Отображена успеваемость для следующего студента:</h3>


        <div class="row">
            <form action="/terms" method="get">
                <div class="col-md-3">
                    <div class="submin_le">

                        <select name="selected" class="form-select semestr list_emestr"
                                aria-label="Default select example">
                            <c:forEach items="${terms}" var="t">
                                <c:choose>
                                    <c:when test="${t.id == selectedTerm.id}">
                                        <option selected value="${t.id}">${t.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${t.id}">${t.name}</option>
                                    </c:otherwise>
                                </c:choose>


                            </c:forEach>
                        </select>

                    </div>
                </div>
                <div class="col-md-3">
                    <div class="submin_le">
                        <div class="choose_input">
                            <input type="submit" class="btn btn-outline-primary " value="Выбрать"></input>
                        </div>
                    </div>
                </div>
            </form>

            <div class="table_progres">

                <div class="col-md-5">
                    <table class="table table-bordered border-primary">

                        <tr>
                            <th width="95%" class="table-active">Название дисциплины</th>
                        </tr>
                        <c:forEach items="${disciplines}" var="d">
                            <tr>
                                <td>"${d.discipline}"</td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>


                <div class="col-md-4">
                    <div class="submin_le">
                        <input class="btn btn-primary  look" type="submit" value="Создать семестр">
                        <form action="/terms-modify" method="get">
                            <input type="hidden" value="${selectedTerm.id}" name="idModify">
                            <input class="btn btn-primary  mody" type="submit"
                                   value="Модифицировать выбранный семестр">
                        </form>
                        <input class="btn btn-primary  delite" type="submit"
                               value="Удалить выбранный семестр">

                    </div>
                </div>


            </div>
        </div>


    </div>


</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>

</html>
