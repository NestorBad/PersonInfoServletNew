<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Add new user</title>
</head>
<body>

<form method="POST" action='ControllerMain' name="frmAddUser">
    User ID : <input type="text" readonly="readonly" name="id_person"
                     value="<c:out value="${person.id_person}" />" /> <br />
    First Name : <input
        type="text" name="first"
        value="<c:out value="${person.first}" />" /> <br />
    Second Name : <input
        type="text" name="second"
        value="<c:out value="${person.second}" />" /> <br />
    Third Name : <input
        type="text" name="third"
        value="<c:out value="${person.third}" />" /> <br />
    Phone : <input
        type="text" name="phone"
        value="<c:out value="${person.phone}" />" /> <br />
    Email : <input type="text" name="email"
                   value="<c:out value="${person.email}" />" /> <br /> <input
        type="submit" value="Submit" />
</form>
</body>