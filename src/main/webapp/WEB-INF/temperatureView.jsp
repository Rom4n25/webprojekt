<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <style><%@include file= "/css/temperature.css"%></style>
    </head>

    <body>

        <header class="header">
            <div class="logout">
                <form action="/logout" >
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main class="main">
            <article class="article">
                <p class="text_check_temperature">Check temperature</pl>

                    <c:if test="${flag}">
                    <div class="div_for_return_text">
                        <p class="returned_text">${temperatura}</p>   
                    </div>
                </c:if>

                <form action="/temperature" method="POST">
                    <input type="text" name="city" placeholder="Type city..">
                    <input type="submit" value="Check">
                </form>

                <form action="/userPanel">
                    <input type="submit" value="Menu">
                </form>

        </main>     
    </article>

</body>

</html>

