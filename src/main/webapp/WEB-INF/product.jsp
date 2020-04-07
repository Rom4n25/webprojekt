<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/product.css"%></style>
    </head>

    <body>
        <header id="header">
        </header>

        <main id="main">
           
            <div class="product">
                <p class="productName">${product.name}</p>
                <p class="productDescription">Manufacturer: ${product.manufacturer}</p>
                <p class="productDescription">Category: ${product.category}</p>
                <p class="productDescription">Price: ${product.unitPrice} PLN</p>
                <p class="productDescription">Liczba sztuk w magazynie: ${product.unitsInStock}</p>
                <p class="productDescription">${product.description}</p>
                <p class="productDescription">${product.condition}</p>
                <a  href=" <spring:url value="/shop/" /> " >
                            Back
                     </a>
                
            </div>
        
            
             
            
        </main>



    </body>
</html>