<%@ taglib prefix="category" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 10.04.2017
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding commodity</title>
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
<div class="addCommodityContainer">
    <form action="/commodityAdd" method="post" enctype="multipart/form-data">
        <h1>Add commodity</h1>
        <label>Category commodity</label>
        <select name="category">
            <option value="-1">none</option>
        <category:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </category:forEach>
        </select>
        <br>
        <label for="name">Name:</label>
        <input name="name" id="name" type="text">
        <br>
        <label for="brand">Brand:</label>
        <input name="brand" id="brand" type="text">
        <br>
        <label for="price">Price:</label>
        <input name="price" id="price" type="number">
        <br>
        <label for="description">Description:</label>
        <textarea rows="10" cols="45" name="description" id="description"></textarea>
        <br><br>
        <label>Select photo</label>
        <input type="file" name="image" multiple accept="image/*" >
        <button type="submit" class="btn btn-primary">Add commodity</button>
    </form>
</div>
</body>
</html>
