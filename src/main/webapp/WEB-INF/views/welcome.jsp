<%--
  Created by IntelliJ IDEA.
  User: mikhailnaryshkin
  Date: 11.04.22
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css"
          rel="stylesheet">
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }
        .footer .container {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }
    </style>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
    <div class="">
        <img src ="/WEB-INF/images/cat_in_pipe.jpg" width="100"
             height="100">
    </div>
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="LoginServlet">Login</a></li>
            <li><a href="LogoutServlet">Logout</a> </li>
        </ul>
    </div>
</nav>
<div class="container">
    <H2>Welcome ${name}</H2>
    <table border="1">
        <caption>Список владельцев питомцев</caption>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Телефон</th>
            <th>email</th>
        </tr>
        <c:forEach items="${group}" var="owner">
            <tr><td>${owner.name}</td>
                <td>${owner.surname}</td>
                <td>${owner.phone}</td>
                <td>${owner.email}</td>
            </tr>
        </c:forEach></table>
<%--    <p><font color="red">${errorMessage}</font></p>--%>
    <form method="POST" action="OwnerListServlet">
        Новый :
        <p> Введите имя <input name="name" type="text" /> </p>
        <p> Введите фамилию <input surname="surname" type="text" /> </p>
        <p> Введите телефон <input name="phone" type="text" /> </p>
        <p> Введите email <input name="email" type="text" /> </p>
        <input name="add" type="submit" />
    </form>
</div>
<footer class="footer">
    <div class="container">
        <p>2022 Все права защищены</p>
    </div>
</footer>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
</body>
</html>
