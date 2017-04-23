<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 08.04.2017
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Login page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Sombra Shop</a>
        </div>

        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button class="btn btn-default" type="submit">
                GO
            </button>
        </form>

        <ul class="nav navbar-nav">
            <li class="active"><a href="/loginpage">Log in</a></li>
            <li ><a href="/registrationPage">Sign up</a></li>
        </ul>
    </div>
</nav>
<div class="loginContainer">
    <form action="/loginprocessing" method="post">
        <h1>Login page</h1>
        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="email" type="text" class="form-control" name="username" placeholder="Login" required> </div>
        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="password" type="password" class="form-control" name="password" placeholder="Password" required> </div>
        <button class="btn btn-primary" type="submit">Sing in></button>
    </form>
</div>
</body>
</html>