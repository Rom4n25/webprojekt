<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <style><%@include file= "/css/myStyle.css"%></style>
        <h1>Sum3Numbers</h1>

        <div>

            <form action="suma3">
                <label for="num1">First Number</label>
                <input type="text" id="num1" name="x1" placeholder="Type first number">

                <label for="num2">Second Number</label>
                <input type="text" id="num2" name="x2" placeholder="Type second number">

                <label for="num3">Second Number</label>
                <input type="text" id="num3" name="x3" placeholder="Type third number">

                <input type="submit" value="SUM!">
                Result: ${result}
            </form>
        </div>


        <div>
            <form action="/menu">
                <input type="submit" value="Back to User Panel">
            </form>
        </div>   

    </body>
</html>
