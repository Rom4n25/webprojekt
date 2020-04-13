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

                <form:form action="/shop/add" method="POST" modelAttribute="newProduct" enctype="multipart/form-data">   

                    <label>Id <p class="error_msg"><form:errors path="productId"/></p></label>
                        <form:input type="text" path="productId" placeholder="Type id..." />

                    <label>Name <p class="error_msg"><form:errors path="name"/></p></label>
                        <form:input type="text" path="name" placeholder="Type name..."/>

                    <label>Price <p class="error_msg"><form:errors path="unitPrice"/></p></label>
                        <form:input type="text" path="unitPrice" placeholder="Type price..."/>

                    <label>Description</label>
                        <form:input type="text" path="description" placeholder="Type description..."/>

                    <label>Manufacturer</label>
                        <form:input type="text" path="manufacturer" placeholder="Type manufacturer..."/>

                    <label>Category</label>
                        <form:input type="text" path="category" placeholder="Type category..."/>

                    <label>Units In Stock</label>
                        <form:input type="text" path="unitsInStock"/><br>

                    <div> Condition
                        <form:radiobutton  path="condition" value="New"/>Nowy
                        <form:radiobutton  path="condition" value="Old"/>Używany
                        <form:radiobutton  path="condition" value="Refurbished"/>Odnowiony
                    </div><br>
                                   
                    <div>
                        <label>Product Image</label>
                        <form:input path="productImage" type="file"/>
                    </div>

                    <input type="submit" value="Add">

                </form:form>
            </div>

        </main>

    </body>
</html>