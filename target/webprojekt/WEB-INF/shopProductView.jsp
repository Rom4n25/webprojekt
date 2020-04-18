<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/product.css"%></style>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

        <script src="/resources/js/controllers.js"></script>
    </head>

    <body>
        <header id="header">
            <div class="logout">
                <form action="/logout" >
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main id="main" >
            <section ng-app="cartApp">
                <div class="product" >
                    <p class="productName">${product.name}</p>
                    <img src="<c:url
                             value="/resources/images/${product.productId}.jpg"></c:url>"
                             alt="image" style = "width:100%"/>
                         <p class="productDescription">Manufacturer: ${product.manufacturer}</p>
                    <p class="productDescription">Category: ${product.category}</p>
                    <p class="productDescription">Price: ${product.unitPrice} PLN</p>
                    <p class="productDescription">Liczba sztuk w magazynie: ${product.unitsInStock}</p>
                    <p class="productDescription">${product.description}</p>
                    <a class="backBtn" href=" <spring:url value="/shop/" /> " >
                        Back
                    </a>

                </div>




                <div class="newDiv" >
                    <p ng-controller="cartCtrl">
                        <a href="#" class="addCart"  ng-click="addToCart('${product.productId}')">
                            <span></span> Zamów teraz </a>
                        <a href="<spring:url value="/cart" />" class="cartBtn">
                            <span></span> Koszyk
                        </a>

                    </p>


                </div>

            </section>
        </main>



    </body>
</html>