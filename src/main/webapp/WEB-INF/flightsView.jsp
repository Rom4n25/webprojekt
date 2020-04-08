<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <style><%@include file= "/css/flights.css"%></style>
    </head>

    <body>

        <header id="header">
             <div class="logout">
                <form action="/logout" >
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main id="main">
            <article id="article1">

                <form action="checkFlights">
                    <p id="text">Choose airport</p>
                    <select id="aname"type="text" name ="airportname">
                        <option value="EPKK">Krakow</option>
                        <option value="EDDF">Frankfurt</option>
                    </select>

                    <label for="dates">Select date </label><br>
                    <input type="date" id="dates" name="date"><br>

                    <label for="times">From </label>
                    <input type="time" id="times" name="time1"><br>

                    <label for="times2">To</label>
                    <input type="time" id="times2" name="time2">

                    <input type="submit" value="Check">
                </form>
                <section>
                    <form action="/backToUserPanel">
                        <input type="submit" value="Menu">
                    </form>
                </section>
                ${result}


            </article>


            <article id="article2">
                <p id="text">Flights:</p>


                <table>
                    <tr>
                        <th>No</th>
                        <th>Flight No</th>
                        <th>From Airport</th>
                        <th>Departure Date</th>
                        <th>Arrival Date</th>
                    </tr>

                    <c:forEach var="emp" items="${depAirports}" varStatus="status">

                        <tr>
                            <th>${status.index}</th>
                            <th>${callsign[status.index]}</th>
                            <th>${emp}</th>
                            <th>${depDate[status.index]}</th>
                            <th>${arrDate[status.index]}</th>


                        </tr>
                    </c:forEach>

                </table>



            </article>


        </main>


    </body>
</html>
