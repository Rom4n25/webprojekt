<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <style><%@include file= "/css/currency.css"%></style>
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

                <p class="text_convert_currency">Convert currency</p>


                <c:if test="${flag}">

                    <div class="div_for_return_text">
                        <p class="returned_text"> ${currency} </p>
                    </div>
                </c:if>
                
                <form action="/currency" method="POST">

                    <input type="text" name="amount" placeholder="Type amount..">

                    <label>From</label>
                    <select "type="text" name ="currency1">
                        <option value="EUR">EUR</option>
                        <option value="PLN">PLN</option>
                        <option value="USD">USD</option>
                        <option value="CAD">CAD</option>
                    </select>

                    <label>To</label>
                    <select type="text" name ="currency2">
                        <option value="EUR">EUR</option>
                        <option value="PLN">PLN</option>
                        <option value="USD">USD</option>
                        <option value="CAD">CAD</option>
                    </select>

                    <input type="submit" value="Convert">
                </form>

                <form action="/userPanel">
                    <input type="submit" value="Menu">
                </form>


            </article>

        </main>

    </body>
</html>
