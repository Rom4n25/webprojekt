<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<body>
<style><%@include file= "/css/myStyle.css"%></style>

<h1>Sum2Numbers</h1>

<div>

    <form action="dodaj">
        <label for="num1">First Number</label>
        <input type="text" id="num1" name="n1" placeholder="Type first number">

        <label for="num2">Second Number</label>
        <input type="text" id="num2" name="n2" placeholder="Type second number">

        <input type="submit" value="SUM!">
        Result: ${result}
    </form>
</div>

<div>
    <form action="/userPanel">
        <input type="submit" value="Back to User Panel">
    </form>
</div>
</body>
</html>













