<%--
  Created by IntelliJ IDEA.
  User: mikhailnaryshkin
  Date: 11.04.22
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>

    <title>Title</title>
</head>
<body>
<div class ="container">
    <section id="content">
<%--        <p><font color="red">${errorMessage}</font></p>--%>
        <form action="/login" method="POST">
        <h1> Вход в систему</h1>
        <div>
            <input placeholder="Имя" required="" id ="username" name="login"
                   type="text" />
        </div>
        <div>
            <input placeholder="Пароль" required=""id ="password"
                   name="password" type="password" />
        </div>
        <div>
            <input  type="submit" value="Войти" />
        </div> <div>
        <a href="register">Регистрация</a> </div>
    </form>
    </section>
</div>
</body>
</html>
