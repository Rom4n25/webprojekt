<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/crudMain.css"%></style>
    </head>

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

    <body>

        <main>

            <div class="bigDiv">
                <div class="headDiv">

                    <p class="headText">Name</p>
                    <p class="headText">Surname</p>
                    <p class="headText">Email</p>



                </div>

                <c:forEach items = "${person}" var="prsn">
                    <div class="detailDiv">


                        <p>${prsn.name}</p>
                        <p>${prsn.surname}</p>
                        <p>${prsn.email}</p>
                        <div class="btnDiv">
                            <p class="boxForBtn">

                                <a class="editBtn" href=" <spring:url value="/crud/edit?id=${prsn.personId}" /> " >
                                    Edit
                                </a>
                            </p>
                            <p class="boxForBtn">
                                <a class="deleteBtn" href=" <spring:url value="/crud/delete?id=${prsn.personId}" /> " >
                                    Delete
                                </a>
                            </p>
                        </div>
                    </div>
                </div>

            </c:forEach>


            <c:if test="${flagAdd}">    
                <div class="formDiv">
                    <form action="/crud/add" method="POST">
                        <label class="labelText">Name</label>
                        <input type="text" name="name" placeholder="Type name..">

                        <label class="labelText">Surname</label>
                        <input type="text" name="surname" placeholder="Type surname...">

                        <label class="labelText">E-mail</label>
                        <input type="text" name="email" placeholder="Type e-mail...">


                        <input type="submit" value="Add">

                    </form>
                </div>
            </c:if> 






            <c:if test="${flag}">
                <div class="formDiv">
                    <form action="/crud/edit" method="POST">
                        <label class="labelText">Name</label>
                        <input type="text" name="name" placeholder="${personById.name}">

                        <label class="labelText">Surname</label>
                        <input type="text" name="surname" placeholder="${personById.surname}">

                        <label class="labelText">E-mail</label>
                        <input type="text" name="email" placeholder="${personById.email}">

                        <input type="hidden" name="personId" value="${personById.personId}" >

                        <input type="submit" value="Update">

                    </form>
                </div>

            </c:if>

            <div class="addDiv">
                <form action="/crud/add" method="GET">

                    <input type="submit" value="Add">

                </form>
            </div>
        </main>



    </body>
</html>
