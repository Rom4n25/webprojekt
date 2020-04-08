<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/shop.css"%></style>
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
            <c:forEach items = "${client}" var="c">
              <div class="product">
                 
                <div class="table1">

                </div>

                <p class="productName">${c.name}</p>
                <p class="productDescription">${c.customerId}</p>
                <p class="productDescription">${c.noOfOrdersMade}</p>
                <p class="productDescription">${c.address}</p>
               
            </div>
            
                </c:forEach>
            
        </main>



    </body>
</html>