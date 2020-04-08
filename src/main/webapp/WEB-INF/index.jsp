<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/index.css"%></style>
    </head>

    <body>
        <header id="header">
        </header>

        <main id="main">

            <article id="article">
                <p id="text">ACCOUNT LOGIN</p>

                <c:if test="${flag}">

                    <div id="div"> 
                        <p id="textError">Wrong username or password!</p>
                    </div>
                    
                </c:if>
                <form action="login" method="POST">


                    <input type="text" id="username" name="username" placeholder="Type username..">

                    <input type="password" id="password" name="password" placeholder="Type password..">

                    <input type="submit" value="Login">

                </form>

            </article>

        </main>

    </body>
</html>