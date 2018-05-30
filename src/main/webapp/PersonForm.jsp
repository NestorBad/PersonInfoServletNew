<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>students</title>
</head>
<body>
<center>
    <h1>Управление студентами</h1>
    <h2>
        <a href="/new">Добавить нового студента</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">Список всех студентов</a>

    </h2>
</center>
<div align="center">
    <c:if test="${person != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${person == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${person != null}">
                            Редактировать
                        </c:if>
                        <c:if test="${person == null}">
                            Добавить
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${person != null}">
                    <input type="hidden" name="id_person" value="<c:out value='${person.id_person}' />"/>
                </c:if>
                <tr>
                    <th>Имя:</th>
                    <td>
                        <input type="text" name="first" size="45"
                               value="<c:out value='${person.first}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Фамилия:</th>
                    <td>
                        <input type="text" name="second" size="45"
                               value="<c:out value='${person.second}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Отчество:</th>
                    <td>
                        <input type="text" name="third" size="45"
                               value="<c:out value='${person.third}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Телефон:</th>
                    <td>
                        <input type="text" name="phone" size="45"
                               value="<c:out value='${person.phone}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>email:</th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${person.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>