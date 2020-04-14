<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

    <head>
        <style><%@include file= "/css/flights.css"%></style>
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
            <article class="article_form">
                <p class="text_check_flights">Check Flights</p>
                <c:if test="${noFlight}">
                    <div class="div_for_return_text">
                        <p class="returned_text"><spring:message code="flightView.noFlight.text"></spring:message></p>
                        </div>
                </c:if>
                <form:form modelAttribute="flight" method="POST">
                    <label class="labelText">Choose airport</label>
                    <form:select type="text" path ="airport">
                        <form:option value="EPKK">Krakow</form:option>
                        <form:option value="EDDF">Frankfurt</form:option>
                    </form:select>

                    <label class="labelText">Select date <p class="error_msg"><form:errors path="date"/></p></label><br>
                    <form:input type="date" path="date"/><br>

                    <label class="labelText">From: <p class="error_msg"><form:errors path="time1"/></p></label>
                    <form:input type="time" path="time1"/><br>

                    <label class="labelText">To: <p class="error_msg"><form:errors path="time2"/></p></label>
                        <form:input type="time" path="time2"/>

                    <input type="submit" value="Check">
                </form:form>


            </article>

            <c:if test="${flag}">  

                <article class="article_out">
                    <p class="text">Flights:</p>

                    <table>
                        <tr>
                            <th>No</th>
                            <th>Flight No</th>
                            <th>From Airport</th>
                            <th>Departure Date</th>
                            <th>Arrival Date</th>
                        </tr>

                        <c:forEach var="variable" items="${depAirports}" varStatus="status">

                            <tr>
                                <th>${status.index}</th>
                                <th>${callsign[status.index]}</th>
                                <th>${variable}</th>
                                <th>${depDate[status.index]}</th>
                                <th>${arrDate[status.index]}</th>
                            </tr>

                        </c:forEach>

                    </table>

                </article>
            </c:if> 
        </main>

    </body>
</html>
