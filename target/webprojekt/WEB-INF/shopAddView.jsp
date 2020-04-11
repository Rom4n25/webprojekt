<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/addProduct.css"%></style>
    </head>

    
    <body>
        <header id="header">
        </header>

        <main id="main">

            <div class="product">

                <form action="/shop/add" method="POST" enctype="multipart/form-data">
                    <label>Id</label>
                    <input type="text" name="productId" placeholder="Type id...">

                    <label>Name</label>
                    <input type="text" name="name" placeholder="Type name...">

                    <label>Price</label>
                    <input type="text" name="unitPrice" placeholder="Type price...">

                    <label>Description</label>
                    <input type="text" name="description" placeholder="Type description...">

                    <label>Manufacturer</label>
                    <input type="text" name="manufacturer" placeholder="Type manufacturer...">

                    <label>Category</label>
                    <input type="text" name="category" placeholder="Type category...">

                    <label>Units In Stock</label>
                    <input type="text" name="unitsInStock"><br>

                    <div> Condition
                        <input type="radio" value="New"/>Nowy
                        <input type="radio" value="Old"/>Używany
                        <input type="radio" value="Refurbished"/>Odnowiony
                    </div>
                    <br>
                    <div>
                        
                        <label>Product Image</label>
                        <input name="productImage" path="productImage" type="file"></input>
                        
                        
                    </div>

                    <input type="submit" value="Add">

                </form>
            </div>




        </main>



    </body>
</html>