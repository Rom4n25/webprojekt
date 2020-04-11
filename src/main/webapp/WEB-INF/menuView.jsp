<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/menu.css"%></style>
    </head>
    <body>
        <header class="header">
            <p class="hello_text">Hello ${username}!</p>
            <div class="logout_div">
                <form action="/logout" >
                    <input class="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main class="main">

            <article class="article_menu">
               
                <p class="menu_text">Menu</p>
                <!--
                <form action="/sumTwoApp">
                    <input type="submit" value="Sum2Numbers">
                </form>

                <form action="/sumThreeApp">
                    <input type="submit" value="Sum3Numbers">
                </form>

                <form action="/herocreate">
                    <input type="submit" value="Create Hero">
                </form>
                -->
                <form action="/temperature">
                    <input type="submit" value="Check temperature">
                </form>

                <form action="/currency">
                    <input type="submit" value="Currency conveter">
                </form>

                <form action="/flight">
                    <input type="submit" value="Check flights">
                </form>

                <form action="/shop">
                    <input type="submit" value="Shop">
                </form>

                <form action="/crud">
                    <input type="submit" value="CRUD App">
                </form>



            </article>
            <article class="article_callendar">
                <p class="menu_text">Callendar</p>

                <iframe src="https://calendar.google.com/calendar/b/1/embed?height=500&amp;wkst=2&amp;bgcolor=%234285F4&amp;ctz=Europe%2FWarsaw&amp;src=bXJvbWFuZWsxODAyQGdtYWlsLmNvbQ&amp;src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&amp;src=cGwucG9saXNoI2hvbGlkYXlAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&amp;color=%23039BE5&amp;color=%2333B679&amp;color=%230B8043" style="border:solid 1px #777" width="400" height="340" frameborder="0" scrolling="no"></iframe>

            </article>

        </main>
    </body>
</html>
