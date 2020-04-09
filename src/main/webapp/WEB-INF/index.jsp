<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/index.css"%></style>
    </head>

    <body>
        <header class="header">
        </header>

        <main class="main">

            <article class="article">
                <p class="account_login_text">ACCOUNT LOGIN</p>

                <c:if test="${flag}">

                    <div class="error_div"> 
                        <p class="account_login_error_text">Wrong username or password!</p>
                    </div>

                </c:if>
                
                <form action="/login" method="POST">

                    <input type="text" name="username" placeholder="Type username..">

                    <input type="password" name="password" placeholder="Type password..">

                    <input type="submit" value="Login">

                </form>

            </article>

        </main>

    </body>
</html>