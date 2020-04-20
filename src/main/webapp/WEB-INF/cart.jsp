<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file= "/css/cart.css"%></style>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
        <script src="/resources/js/controllers.js"></script>


    </head>
    <header>

    </header>

    <body>

        <main>
            <section ng-app="cartApp">
                <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

                    <div>
                        <a class="clearBtn" ng-click="clearCart()">
                            <span></span>Wyczyść koszyk
                        </a>
                        <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="buyBtn">
                            Kupuję
                        </a>
                    </div>
                    <table class="table">
                        <tr>
                            <th>Produkt</th>
                            <th>Cena za sztukę</th>
                            <th>Liczba sztuk</th>
                            <th>Cena</th>
                            <th>Akcja</th>

                        </tr>
                        <tr ng-repeat="item in cart.cartItems">
                            <td>{{item.product.productId}}-{{item.product.name}}</td>
                            <td>{{item.product.unitPrice}} PLN</td>
                            <td>{{item.quantity}}</td>
                            <td>{{item.totalPrice}} PLN</td>
                            <td><a href="#" class="deleteBtn" ng-click="removeFromCart(item.product.productId)">
                                    <span></span>Usuń
                                </a></td>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Łączna cena</th>
                            <th>{{cart.grandTotal}} PLN</th>
                            <th></th>
                        </tr>
                    </table>

                    <a href="<spring:url value="/shop" />" class="backBtn">
                        Wróć do zakupów
                    </a>
                </div>
            </section>
        </main>
    </body>
</html>