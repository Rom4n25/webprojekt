<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

    <head>
        <style><%@include file= "/css/note.css"%></style>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

        <script src="/resources/js/notecontrollers.js"></script>
    </head>

    <body>

        <header class="header">
            <div class="logout">
                <form action="/logout" >
                    <input class="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>

            <div class="menu">
                <form action="/menu" >
                    <input class="menuBtn" type="submit" value="Menu" >
                </form>
            </div>
        </header>

        <main class="main" ng-app="cartApp" ng-controller="cartCtrl" ng-init="initNoteId('${note}')">

            <article class="art_for_small_notes">

                <div ng-repeat="item in note.noteList" class="small_note_div"><p class="p_title">{{item.title}}</p><br><p class="p_dsc">{{item.description}}</p><br>


                    <a class="deleteNoteBtn" href="#"   ng-click="removeNote(item.id)"> <!-- gdy kliknę to zadziala z kontrollera metoda addToCart z parametrem productId -->
                        Usuń </a> 

                </div>

            </article>

            <article class="blankNote" >

                <input type="text" name="name" placeholder="Set title..." ng-model="name"></input>
               
                <textarea name="dsc" rows="10" cols="30" placeholder="Message..." ng-model="dsc"></textarea>
            
                <a class="addNoteBtn" href="#"   ng-click="createNote()">
                    Dodaj </a> 


            </article>  




        </main>     


    </body>

</html>

