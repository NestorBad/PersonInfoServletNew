<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: honey
  Date: 28.05.18
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Список Студентов</h1>
    <h2>
        <a href="/new">Добавить нового Студента</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">Список всех Студентов</a>
    </h2>
</center>
<div align="center">
<table  border="1" cellpadding="5">
    <caption><h2>Список Студентов</h2></caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Телефон</th>
        <th>email</th>
        <th colspan="2">Действия</th>
    </tr>

    <c:forEach items="${persons}" var="person">
        <tr>
            <td><c:out value="${person.id_person}"/></td>
            <td><c:out value="${person.first}"/></td>
            <td><c:out value="${person.second}"/></td>
            <td><c:out value="${person.third}"/></td>
            <td><c:out value="${person.phone}"/></td>
            <td><c:out value="${person.email}"/></td>

            <td>
                <a href="/edit?id=<c:out value='${person.id_person}'/>">Редактировать</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete?id=<c:out value='${person.id_person}'/>">Удалить</a>
            </td>

        </tr>
    </c:forEach>

</table>
</div>
</body>
</html>