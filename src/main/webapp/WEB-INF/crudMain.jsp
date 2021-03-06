<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/crudMain.css"%></style>
    </head>

    <header>

    </header>
    <body>

        <main>

            <div>

                <p class="headText">Name</p>
                <p class="headText">Surname</p>
                <p class="headText">Email</p>



            </div>

            <c:forEach items = "${person}" var="prsn">
                <div>


                    <p>${prsn.name}</p>
                    <p>${prsn.surname}</p>
                    <p>${prsn.email}</p>
                    <p class="box">
                        <a class="edit" href=" <spring:url value="/crud/edit?id=${prsn.personId}" /> " >
                            Edit
                        </a>
                    </p>
                    <p class="box">
                        <a class="delete" href=" <spring:url value="/crud/delete?id=${prsn.personId}" /> " >
                            Delete
                        </a>
                    </p>
                </div>

            </c:forEach>

            <div class="add">
                <form action="/crud/add" method="GET">

                    <input type="submit" value="Add">

                </form>
            </div>
        </main>



    </body>
</html>
