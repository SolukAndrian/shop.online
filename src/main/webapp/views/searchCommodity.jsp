<%@ taglib prefix="com" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="category" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 14.04.2017
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search commodity</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Sombra Shop</a>
        </div>

        <form action="/searchCommodity" method="post" class="navbar-form navbar-left">
            <div class="form-group">
                <input name="search" type="text" class="form-control" placeholder="Search">
            </div>
            <button class="btn btn-default" type="submit">
                GO
            </button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/commodityAdd"><span class="glyphicon glyphicon-plus"></span> Add commodity</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/categoryAdd"><span class="glyphicon glyphicon-plus"></span> Add category</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')"><li><a href="/userBasket"><span class="glyphicon glyphicon-shopping-cart"></span> Basket</a></li></sec:authorize>
            <sec:authorize access="isAuthenticated()"><li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/loginpage"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/registrationPage"><span class="glyphicon glyphicon-list-alt"></span> Registration page</a></li></sec:authorize>

        </ul>

    </div>
</nav>
<div class="category">
    <category:forEach var="category" items="${categories}">
        <div class="category1">${category.name}</div>
    </category:forEach>
</div>
<div class="container">
    <com:forEach var="com" items="${commodityS}">
        <a href="/commodity/${com.id}">
            <div class="commodity">
                <h2>${com.brand} ${com.name}</h2>
                <img src="/imageDisplay?id=${com.id}" alt="">
                <div class="price">${com.price}$</div>
                <div class="description">${com.description}</div>
                <div class="button1">
                    <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/commodity/edit/${com.id}"><button class="b1"><span class="glyphicon glyphicon-edit"></span>edit</button></a></sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/deleteCommodity/${com.id}">  <button class="b2"><span class="glyphicon glyphicon-trash"></span>delete</button></a></sec:authorize>
                    <sec:authorize access="hasRole('ROLE_USER')"><a href="/addToBasket/${com.id}"><button class="b3"><span class="glyphicon glyphicon-shopping-cart"></span>Add to busket</button></a></sec:authorize>
                </div>
            </div>
        </a>
    </com:forEach>
</div>


</body>
</html>

