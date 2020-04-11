<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <form action="/flight" method="POST">
                    <label class="labelText">Choose airport</label>
                    <select "type="text" name ="airportname">
                        <option value="EPKK">Krakow</option>
                        <option value="EDDF">Frankfurt</option>
                    </select>

                    <label class="labelText">Select date </label><br>
                    <input type="date" name="date"><br>

                    <label class="labelText">From: </label>
                    <input type="time" name="time1"><br>

                    <label class="labelText">To:</label>
                    <input type="time" name="time2">

                    <input type="submit" value="Check">
                </form>

             

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
