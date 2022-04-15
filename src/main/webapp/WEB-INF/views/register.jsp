<%--
  Created by IntelliJ IDEA.
  User: mikhailnaryshkin
  Date: 11.04.22
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <html>
<head>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <title>Title</title>
</head>
<body>
<div class ="container">
    <section id="content">

        <form action="/register" method="POST">
<%--            <p><font color="red">${errorRegister}</font></p>--%>
            <h1> Регистрация нового владельца </h1> <div>
            <input placeholder="Введите имя" required=""name="newLoginName" type="text" />
        </div>
            <div>
                <input placeholder="Введите пароль" id ="password" required=""
                       name="newPassword" type="password" /> </div>
            <div>
                <input type="submit" value="Зарегистрировать"/> </div>
        </form>
    </section>
</div>
</body>
</html>