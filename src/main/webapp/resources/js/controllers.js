var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function ($scope, $http) {


    $scope.initCartId = function (cartId) { //inicjalizuje $scope.cartId i przypisuje mu wartosc cartId aby mozna bylo z niego korzystac w innych metodach kontrolera
        $scope.cartId = cartId;
        $scope.refreshCart();
    };


    $scope.refreshCart = function () {
        $http.get('/rest/cart/' + $scope.cartId) //tutaj trafia cartId w postaci Stringu i leci do restowego kontrolera żeby dostać body Koszyka
                .then(function onSuccess(response) {
                    $scope.cart = response.data;//określam, że w jako odpowiedzi chce dostać dane, które nastepnie będą przechowywane w $scope.cart
                });
    };


    $scope.addToCart = function (productId) { //określam, że addToCart jest rowne funkcji bez nazwy, która przyjmuje parametr productId - mam go z Widoku
        $http.put('/rest/cart/add/' + productId)    //dzieki %http.put wykonuje żądanie do restowej metody put (a dokladnie do @Put Mapping("/rest/cart/add/{productId}")
                .then(alert("Produkt pomyślnie dodany do Kosza!")); //wyswietlam okienko popup
        //ten rest zwraca mi body
    };



    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId)
                .then($scope.refreshCart());

    };


    $scope.clearCart = function () {
        $http.delete('/rest/cart/' + $scope.cartId)
                .then($scope.refreshCart());
        //restowy controller nic nie zwraca wiec nie potrzebuje zandego onSuccess(response)
        //musze natomaist odswiezyc karte

    };




});