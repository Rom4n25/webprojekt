<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <style><%@include file= "/css/currency.css"%></style>
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
            <article id="article">


                <form action="waluta2">
                    <p id="text">Convert currency</p>
                    <div id="div">

                        <p id="returnText"> ${msg} </p>
                    </div>
                    <input type="text" id="hname" name="amount" placeholder="Type amount..">

                    <label for="lname">From</label>
                    <select id="lname"type="text" name ="currency1">
                        <option value="EUR">EUR</option>
                        <option value="PLN">PLN</option>
                        <option value="USD">USD</option>
                        <option value="CAD">CAD</option>
                    </select>

                    <label for="cname">To</label>
                    <select type="text" id="cname"name ="currency2" >
                        <option value="EUR">EUR</option>
                        <option value="PLN">PLN</option>
                        <option value="USD">USD</option>
                        <option value="CAD">CAD</option>
                    </select>

                    <input type="submit" value="Convert">
                </form>

                <form action="/backToUserPanel">
                    <input type="submit" value="Menu">
                </form>


            </article>

        </main>

    </body>
</html>
