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
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main class="main">
            <article class="article_form">

                <form action="/flight" method="POST">
                    <p class="text">Choose airport</p>
                    <select "type="text" name ="airportname">
                        <option value="EPKK">Krakow</option>
                        <option value="EDDF">Frankfurt</option>
                    </select>

                    <label>Select date </label><br>
                    <input type="date" name="date"><br>

                    <label>From </label>
                    <input type="time" name="time1"><br>

                    <label>To</label>
                    <input type="time" name="time2">

                    <input type="submit" value="Check">
                </form>

                <section>
                    <form action="/userPanel">
                        <input type="submit" value="Menu">
                    </form>
                </section>

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
