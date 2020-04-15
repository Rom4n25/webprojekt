<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file= "/css/crudMain.css"%></style>
    </head>

    <header class="header">
        <div class="logout">
            <form action="/logout" >
                <input class="logoutBtn" type="submit" value="<spring:message code="menuView.input.logout.button"/>">
            </form>
        </div>    

        <div class="menu">
            <form action="/menu" >
                <input class="menuBtn" type="submit" value="Menu" >
            </form>
        </div>
    </header>

    <body>

        <main>

            <div class="bigDiv">
                <div class="headDiv">

                    <p class="headText"><spring:message code="crudView.name.message"/></p>
                    <p class="headText"><spring:message code="crudView.surname.message"/></p>
                    <p class="headText"><spring:message code="crudView.email.message"/></p>



                </div>

                <c:forEach items = "${allPersons}" var="person">
                    <div class="detailDiv">


                        <p>${person.name}</p>
                        <p>${person.surname}</p>
                        <p>${person.email}</p>
                        <div class="btnDiv">
                            <p class="boxForBtn">

                                <a class="editBtn" href=" <spring:url value="/crud/edit?id=${person.personId}" /> " >
                                    <spring:message code="crudView.edit.button"/>
                                </a>
                            </p>
                            <p class="boxForBtn">
                                <a class="deleteBtn" href=" <spring:url value="/crud/delete?id=${person.personId}" /> " >
                                    <spring:message code="crudView.delete.button"/>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>

            </c:forEach>


            <c:if test="${flagAdd}">    
                <div class="formDiv">
                    <form:form modelAttribute="newPerson" action="/crud/add" method="POST">
                        <label class="labelText"><spring:message code="crudView.name.message"/><p class="error_msg"><form:errors path="name"/></p></label>
                        <spring:message code="crudView.name.placeholder" var="placeholderName"/>
                            <form:input type="text" path="name" placeholder="${placeholderName}"/>

                        <label class="labelText"><spring:message code="crudView.surname.message"/><p class="error_msg"><form:errors path="surname"/></p></label>
                        <spring:message code="crudView.surname.placeholder" var="placeholderSurname"/>
                        <form:input type="text" path="surname" placeholder="${placeholderSurname}"/>

                        <label class="labelText"><spring:message code="crudView.email.message"/><p class="error_msg"><form:errors path="email"/></p></label>
                        <spring:message code="crudView.email.placeholder" var="placeholderEmail"/>
                        <form:input type="text" path="email" placeholder="${placeholderEmail}"/>


                        <input type="submit" value="<spring:message code="crudView.add.button"/>">

                    </form:form>
                </div>
            </c:if> 


            <c:if test="${flagEdit}">
                <div class="formDiv">
                    <form:form modelAttribute="personById" action="/crud/edit" method="POST">
                        <label class="labelText"><spring:message code="crudView.name.message"/><p class="error_msg"><form:errors path="name"/></p></label>
                        <form:input type="text" path="name" placeholder="${personById.name}"/>

                        <label class="labelText"><spring:message code="crudView.surname.message"/><p class="error_msg"><form:errors path="surname"/></p></label>
                        <form:input type="text" path="surname" placeholder="${personById.surname}"/>

                        <label class="labelText"><spring:message code="crudView.email.message"/><p class="error_msg"><form:errors path="email"/></p></label>
                        <form:input type="text" path="email" placeholder="${personById.email}"/>

                        <form:input type="hidden" path="personId" value="${personById.personId}" />

                        <input type="submit" value="<spring:message code="crudView.update.button"/>">

                    </form:form>
                </div>

            </c:if>
            
            <c:if test="${!buttonAddParam}">
            <div class="addDiv">
                <form action="/crud/add" method="GET">

                    <input type="submit" value="<spring:message code="crudView.add.button"/>">

                </form>
            </div>
            </c:if>
            
              <c:if test="${buttonAddParam}">
            <div class="addDiv">
                <form action="/crud" method="GET">

                    <input type="submit" value="<spring:message code="crudView.back.button"/>">

                </form>
            </div>
            </c:if>
        </main>


    </body>
</html>
