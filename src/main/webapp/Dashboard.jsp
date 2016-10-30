<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  local.entities.User: Smith
  Date: 30.10.2016
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h3>Пользователь</h3>
    <table>
        <tr>
            <td>e-mail:</td><td>${user.email}</td>
        </tr>
        <tr>
            <td>Фамилия:</td><td>${user.surname}</td>
        </tr>
        <tr>
            <td>Имя:</td><td>"${user.name}</td>
        </tr>
    </table>
    <form action="<c:url value="/auth"/>" method="POST">
        <input type="hidden" name="user_id" value="${user.id}"/>
        <input type="submit" name="LogOut" value="Выйти"/>
    </form>
</body>
</html>
