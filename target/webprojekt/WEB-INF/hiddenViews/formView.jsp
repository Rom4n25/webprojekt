<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <style><%@include file= "/css/myStyle.css"%></style>
</head>
<body>

    <h1>Form Panel</h1>

<div>
    <form action="createmyhero">
        <label for="hname">Hero name</label>
        <input type="text" id="hname" name="name" placeholder="Type hero name..">

        <label for="lname">Weapon type</label>
        <select id="lname"type="text" name ="weapon.weapontype">
            <option value="gun">Gun</option>
            <option value="sword">Sword</option>
        </select>

        <label for="cname">Vehicle type</label>
        <select type="text" id="cname"name ="vehicle.vehicletype" >
            <option value="car">Car</option>
            <option value="bike" >Bike</option>
        </select>

        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
