var cartApp = angular.module('cartApp', []); //inicjalizuje moduł aplikacji, którego nazwą jest 'cartApp'

cartApp.controller('cartCtrl', function ($scope, $http) { //w module aplikacji tworzę kontroler o nzawie 'cartCtrl', który przyjmuje elementy $scope oraz $http
                                                          //$dzieki $scope obiekt/element jest widoczny wszedzie w kontrolerze oraz w widoku - zeby w widoku odwolać się do $scope.name wpisuje {{name}}
                                                          
    $scope.initNoteId = function (noteId) {         //tworzę metode inicjalizacyjną, która tworzy $scope.noteIdd
        $scope.name = null;
        $scope.dsc = null;
        $scope.noteIdd = noteId;
        $scope.refreshNoteList();

    };



    $scope.refreshNoteList = function () {
        $http.get('/rest/crud/' + $scope.noteIdd)
                .then(function onSuccess(response) {
                    $scope.name = null; //to po to aby za kazdym dodaniem notatki usuwaly sie wpisane wartosci
                    $scope.dsc = null;
                    $scope.note = response.data;
                });
    };



    $scope.createNote = function () {
        if ($scope.name === null) {

            $scope.name = "empty";
        }

        if ($scope.dsc === null) {

            $scope.dsc = "empty";
        }


        $http.put('/rest/crud/add/' + $scope.noteIdd)
                .then(function onSuccess(response) {

                    $scope.noteItemId = response.data;

                    $http.put('/rest/crud/set/' + $scope.noteIdd + '/' + $scope.noteItemId + '/' + $scope.name + '/' + $scope.dsc)
                            .then($scope.refreshNoteList());


                });

    };



    $scope.removeNote = function (noteId) {
        $http.put('/rest/crud/delete/' + $scope.noteIdd + '/' + noteId)
                .then($scope.refreshNoteList());

    };


});