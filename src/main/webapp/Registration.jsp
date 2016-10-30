<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  local.entities.User: Smith
  Date: 30.10.2016
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <form action="<c:url value="/commit_reg"/>" method="POST">
        <table>
            <tr>
                <td>E-mail</td><td><input type="e-mail" required name="e-mail"/></td>
            </tr>
            <tr>
                <td>Пароль</td><td><input type="password" required name="password"/></td>
            </tr>
            <tr>
                <td>Имя</td><td><input type="text" required name="name"/></td>
            </tr>
            <tr>
                <td>Фамилия</td><td><input type="text" required name="surname"/></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input type="submit" value="Зарегистрироваться" name="OK"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
