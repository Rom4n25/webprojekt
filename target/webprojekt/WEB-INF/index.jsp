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
            <div class="language_div">
                
                <form action="/login/" >
                    <input class="languageBtn" type="submit" name="language" value="PL" >
                </form>
                <form action="/login/" >
                    <input class="languageBtn" type="submit" name="language" value="US" >
                </form>
                
            </div>
        </header>

        <main class="main">

            <article class="article">
                <p class="account_login_text"><spring:message code="index.p.account.login.text"></spring:message></p>

                <c:if test="${flag}">

                    <div class="error_div"> 
                        <p class="account_login_error_text">Wrong username or password!</p>
                    </div>

                </c:if>

                <form action="/login" method="POST">

                    <input type="text" name="username" placeholder="<spring:message code="index.input.placeholder.username.text"></spring:message>">

                    <input type="password" name="password" placeholder="<spring:message code="index.input.placeholder.password.text"></spring:message>">

                    <input type="submit" value="<spring:message code="index.input.login.button"></spring:message>">

                </form>

            </article>

        </main>

    </body>
</html>