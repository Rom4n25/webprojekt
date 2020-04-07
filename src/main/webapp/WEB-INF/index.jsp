<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/index.css"%></style>
    </head>

    <body>
        <header id="header">
        </header>

        <main id="main">

            <article id="article">
                <p id="text">ACCOUNT LOGIN</p>
                <div id="div"> 
                    <p id="textError">${loginNotSucces}</p>
                </div>

                <form action="login" method="POST">


                    <input type="text" id="username" name="username" placeholder="Type username..">

                    <input type="password" id="password" name="password" placeholder="Type password..">

                    <input type="submit" value="Login">

                </form>

            </article>

        </main>

    </body>
</html>