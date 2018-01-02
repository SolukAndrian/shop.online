<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 08.04.2017
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
            <a class="navbar-brand" href="/">Simple Shop</a>
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
            <li><a href="/loginpage">Log in</a></li>
            <li class="active"><a href="/registrationPage">Sign up</a></li>
        </ul>
    </div>
</nav>
<div class="registration">
    <form action="/registration" method="post">
        <h1>Registration form</h1>
        <p id="errorMessage1"></p>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="surname" type="text" class="form-control" name="surname" placeholder="Input your surname"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="name" type="text" class="form-control" name="name" placeholder="Input your name"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <input id="address" type="text" class="form-control" name="address" placeholder="Input your home address"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input id="email" type="email" class="form-control" name="email" placeholder="Input your email"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input id="login" type="text" class="form-control" name="login" placeholder="Input your login"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
            <input id="phone" type="tel" class="form-control" name="phone" placeholder="Input your phone"> </div>
        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="password" type="password" class="form-control" name="password" placeholder="Input your password"> </div>

        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="passwordConfirm" type="password" class="form-control" name="passwordConfirm" placeholder="Confirm your password"> </div>
    <button id="click">Sing up ></button>
</form>
    <script src="../resources/jquery/jquery-3.2.0.min.js"></script>
    <script>
        $(document).ready(function(){

            $("#click").click(function (e) {
                e.preventDefault();

                if(validate(getObject())){
                    $.ajax({
                        url: '/registration',
                        method: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(getObject()),
                        success: function(){
                            window.location.assign("/loginpage")
                        }
                    })
                }
            })

            function getObject() {
                return {
                    surname: $("#surname").val()
                    , name: $("#name").val()
                    , address: $("#address").val()
                    , email: $("#email").val()
                    , login: $("#login").val()
                    , phone: $("#phone").val()
                    , password: $("#password").val()
                }
            }

            function showError(message) {
                $("#errorMessage1").empty();
                $("#errorMessage1").append("<p style='color: darkred;text-align: center'>Check your " + message + "</p>")


            }

            function validate(object) {
                var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var phoneRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
                if (object.surname == "") {
                    showError("surname")
                    return false;
                }
                if (object.name == "") {
                    showError("name")
                    return false;
                }
                if (object.address == "") {
                    showError("address")
                    return false;
                }
                if (object.phone == "" || !object.phone.match(phoneRegex)) {
                    showError("phone")
                    return false;
                }
                if (object.email == "" || !object.email.match(emailRegex)) {
                    showError("email")
                    return false;
                }
                if (object.login == "") {
                    showError("login")
                    return false;
                }

                if (object.password == "" || object.password != $("#passwordConfirm").val()) {
                    showError("password")
                    return false;
                }
                return true;
            }
        })

    </script>
</div>
</body>
</html>

