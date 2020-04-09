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
            <div class="logout">
                <form action="/logout" >
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>
        </header>

        <main id="main">


            <div class="filterMenu">


                <div>

                    <p class="text">Category</p>
                    <form action="/shop/">
                        <input class="catBtn" type="submit" value="All Products">
                    </form>  
                    <form action="/shop/laptop">
                        <input class="catBtn" type="submit" value="Laptop">
                    </form>  
                    <form action="/shop/tablet">
                        <input class="catBtn" type="submit" value="Tablet">
                    </form>  
                    <form action="/shop/smartphone">
                        <input class="catBtn" type="submit" value="Smartphone">
                    </form>  

                </div>

                <div>

                    <p class="text">Filter</p>
                    
                    <form action="/shop/price">
                        <label>Hero name</label>
                        <input type="text"  name="low" placeholder="Type lowest price">
                        <input type="text"  name="high" placeholder="Type highest price">
                           <input type="submit" value="Filter">
                    </form>
                    
                    

                        </div>


                        <div>

                            <p class="text">Admin Panel</p>

                            <div>
                                <form action="/shop/add" >
                                    <input name="addBtn" type="submit" value="Add Product" >
                                </form>
                            </div>

                        </div>


                </div>


                <div class="boxForProducts">

                    <c:forEach items = "${products}" var="product">
                        <div class="product">

                            <div class="table1">

                            </div>

                            <p class="productName">${product.name}</p>
                            <img src="<c:url
                                     value="/resources/images/${product.productId}.jpg"></c:url>"
                                     alt="image" style = "width:100%"/>
                                 <p class="productDescription">${product.description}</p>
                            <p class="productPrice">${product.unitPrice} PLN</p>
                            <p class="productStock">Liczba sztuk w magazynie: ${product.unitsInStock}</p>



                            <a  href="<spring:url value="/shop/product?id=${product.productId}"></spring:url> ">
                                    Details </a>

                            </div>

                    </c:forEach>

                </div>    




        </main>



    </body>

</html>