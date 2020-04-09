<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<body>
<style><%@include file= "/css/myStyle.css"%></style>

<h3>Created Hero</h3>

Hero's name: ${hero1.name} <br>
Hero's vehicle: ${hero1.vehicle.vehicletype}<br>
Hero's weapon: ${hero1.weapon.weapontype}

<div>
    <form action="/userPanel">
        <input type="submit" value="Back to User Panel">
    </form>
</div>
</body>
</html>

