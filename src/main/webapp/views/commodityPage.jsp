<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 17.04.2017
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${commodity.name} ${commodity.brand}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style2.css"> </head>

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


<div class="container">
    <div class="imgSSS">
        <img id="myImg" src="/imageDisplay?id=${commodity.id}" alt="" width="300" height="250">
        <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/deleteCommodity/${commodity.id}"><button class="but1">Delete commodity</button></a></sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/commodity/edit/${commodity.id}"><button class="but2">Edit commodity</button></a></sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')"><a href="/addToBasket/${commodity.id}"><button class="but3">Add to basket</button></a></sec:authorize>
        <sec:authorize access="isAnonymous()"><a href="/loginpage"><button class="but4">Add to basket</button></a></sec:authorize>

    </div>

    <!-- The Modal -->
    <div id="myModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="img01">
    </div>

    <div class="container2">
        <div class="nameInfo"><h2>${commodity.brand} ${commodity.name}</h2>
            <h3>Price: ${commodity.price} $</h3>
            <h3>Category: ${commodity.category.name}</h3>
        </div><hr>
        <div class="description">

            <h3>Description: </h3>
            ${commodity.description}
        </div>
    </div>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var img = document.getElementById('myImg');
    var modalImg = document.getElementById("img01");
    var captionText = document.getElementById("caption");
    img.onclick = function(){
        modal.style.display = "block";
        modalImg.src = this.src;
    }

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }
</script>
</body>

</html>
