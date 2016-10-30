<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Авторизация</title>
    </head>

    <body>
        <form action="<c:url value="/commit_auth"/>" method="POST">
            <table>
                <tr>
                    <td>E-mail</td><td><input required type="e-mail" name="e-mail"/></td>
                </tr>
                <tr>
                    <td>Пароль</td><td><input required type="password" name="password"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input type="submit" name="LogIn" value="Войти"/></td>
                </tr>
            </table>
        </form>
        <form action="<c:url value="/register"/>" method="GET">
            <table>
                <tr>
                    <td><input type="submit" name="Register" value="Зарегистрироваться"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>