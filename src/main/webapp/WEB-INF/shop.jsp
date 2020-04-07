<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/shop.css"%></style>
    </head>

    <body>
        <header id="header">
        </header>

        <main id="main">
            
           
           
            <div class="filterMenu">
                
            
            </div>
                
                
            <div class="boxForProducts">
                
            <c:forEach items = "${products}" var="product">
                <div class="product">

                    <div class="table1">

                    </div>

                    <p class="productName">${product.name}</p>
                    <p class="productDescription">${product.description}</p>
                    <p class="productPrice">${product.unitPrice} PLN</p>
                    <p class="productStock">Liczba sztuk w magazynie: ${product.unitsInStock}</p>

                  
                    
                     <a  href=" <spring:url value="/shop/product?id=${product.productId}" /> " >
                            Details
                     </a>
                              
                    
                   
                      
                    

                </div>

            </c:forEach>

            </div>    
            
            
                
                
        </main>



    </body>
</html>