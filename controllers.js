/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cartApp = angular.module('cartApp', []);
cartApp.controller('cartCtrl', function ($scope, $http) {
    
    $scope.refreshCart = function (cartId) {
        $http.get('/rest/cart/' + $scope.cartId)
                .success(function (data) {
                    $scope.cart = data;
                });
    };
    
    
    
    $scope.clearCart = function () {
        $http.delete('/rest/cart/' + $scope.cartId)
                .success($scope.refreshCart($scope.cartId));
    };
    
    
    
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };
    
    
    
    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/' + productId)
                .success(function (data) {
                    $scope.refreshCart($http.get('/rest/cart/get/cartId'));
                    alert("Produkt dodany do koszyka!");
                });
    };
    
    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId)
                .success(function (data) {
                    $scope.refreshCart($http.get('/rest/cart/get/cartId'));
                });
    };
});
