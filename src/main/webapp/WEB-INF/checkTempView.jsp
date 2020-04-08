<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <style><%@include file= "/css/checkTemp.css"%></style>
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
                <p id="text">Check temperature</pl>
                <div id="div">
                     <p id="returnText">${temperatura}</p>   
                </div>
                <form action="/checkTemp">

                    <input type="text" id="hname" name="city" placeholder="Type city..">
                    <input type="submit" value="Check">
                </form>

                <form action="/backToUserPanel">
                    <input type="submit" value="Menu">
                </form>
               

        </main>     
    </article>

</body>

</html>

