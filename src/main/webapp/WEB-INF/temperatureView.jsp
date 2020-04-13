<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

    <head>
        <style><%@include file= "/css/temperature.css"%></style>
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

        <main class="main">
            <article class="article">
                <p class="text_check_temperature">Check temperature</pl>

                    
                    <c:if test="${flag_error_blank}">
                    <div class="div_for_return_text">
                        <p class="returned_text"><spring:message code="temperatureView.returned.error_text"></spring:message> </p>   
                    </div>
                    </c:if>
                    
                    <c:if test="${flag_error_notfound}">
                    <div class="div_for_return_text">
                        <p class="returned_text"><spring:message code="temperatureView.returned.errorNotFound_text"></spring:message> </p>   
                    </div>
                    </c:if>
                    
                                      
                    <c:if test="${flag_return}">
                    <div class="div_for_return_text">
                        <p class="returned_text">${city} - <spring:message code="temperatureView.returned.text"></spring:message> ${temperatura} [C]</p>   
                    </div>
                    </c:if>

                <form action="/temperature" method="POST">
                    <input type="text" name="city" placeholder="Type city.."/>
                    <input type="submit" value="Check">
                </form>

              
        </main>     
    </article>

</body>

</html>

