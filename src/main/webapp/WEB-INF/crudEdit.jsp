<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/crudMain.css"%></style>
    </head>
    
    <header>
         <div class="logout">
                <form action="/logout" >
                    <input name="logoutBtn" type="submit" value="Logout" >
                </form>
            </div>

    </header>
    <body>
        
        <main>
        
               <div>
                   
                <p class="headText">Name</p>
                <p class="headText">Surname</p>
                <p class="headText">Email</p>
              
                
           
            </div>
            
       
                <div>

                   
                    <p>${person.name}</p>
                    <p>${person.surname}</p>
                    <p>${person.email}</p>
                    <p class="box">
                        <a class="edit"  href=" <spring:url value="/crud/edit?id=${person.personId}" /> " >
                            Edit
                     </a>
                            </p>
                           <p class="box">  
                   <a class="delete" href=" <spring:url value="/crud/delete?id=${person.personId}" /> " >
                            Delete
                     </a>
                    </p>
                </div>

            <div>
            <form action="/crud/edit" method="POST">
                    <label>Name</label>
                    <input type="text" name="name" placeholder="${person.name}">

                    <label>Surname</label>
                    <input type="text" name="surname" placeholder="${person.surname}">

                    <label>E-mail</label>
                    <input type="text" name="email" placeholder="${person.email}">
                        
                    <input type="hidden" name="personId" value="${person.personId}" >
                    
                    <input type="submit" value="Update">

                </form>
        </div>
        </main>
        
        
        
    </body>
</html>
