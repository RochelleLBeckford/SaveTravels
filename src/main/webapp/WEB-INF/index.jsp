<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1 class="text-center">Save Travels</h1>
    <!-- 
        -> for loop -> make a table to display all expense 
    -->
    <table class="table container center table-hover text-center table-striped">
        <thead>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <!-- these are going to be my actions -> edit & delete -->
            <th>Actions</th>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <!-- can interate through and list all my expenses -->
                    <td>
                        <a href="/expenses/${expense.id}">
                            ${expense.expenseName}
                        </a>
                    </td>
                    <td>${expense.vendor}</td>
                    <td>${expense.amount}</td>
                        <!--  
                            -> add'tl table data that will be my actions 
                            -> need to make route where link will go 
                            -> /expenses/edit/id
                        -->
                    <td class="d-flex gap-2">
                        <a href="/expenses/edit/${expense.id}">
                            Edit
                        </a>
                        <!-- this is for the delete 
                            -> we have to include the hidden input which is why the <form> tag is needed
                            -> the work around if we want to use put
                            -> must follow the restful routing 
                            -> need to create a route for delete
                            -> must create a a method for delete
                        -->
                        <form action="/expenses/${expense.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input class="btn btn-danger" type="submit" value="Delete">
                        </form>
                    </td>
                </tr>v
            
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 
        -> form that is going to let me add an expense 
        -> action -> the tourte that is going to handle this form data 
            !-> remember to use restful routing convention 
        -> if using form:form have to add modelAttribute -> traditional form do not
            -> do not use a traditional form
        -> form:form is easier to do with validations 
    -->
    <form:form class="container center" action="/expenses" method="post" modelAttribute="expense">
        <h2>Add an Expense: </h2>
        <div class="form-control">
            <!--
                -> not need everything an expense has
                -> path of whatever attribute I am setting
            -->
            <form:label path="expenseName">Expense Name: </form:label>
            <!-- want errors to show -->
            <form:errors class="text-danger" path="expenseName"></form:errors>
            <form:input path="expenseName"></form:input>
        </div>

        <div class="form-control">
            <!--
                -> not need everything an expense has
                -> path of whatever attribute I am setting
            -->
            <form:label path="vendor">Vendor: </form:label>
            <!-- want errors to show -->
            <form:errors class="text-danger" path="vendor"></form:errors>
            <form:input path="vendor"></form:input>
        </div>

        <div class="form-control">
            <!--
                -> not need everything an expense has
                -> path of whatever attribute I am setting
            -->
            <form:label path="amount">Amount: </form:label>
            <!-- want errors to show -->
            <form:errors class="text-danger" path="amount"></form:errors>
            <form:input path="amount"></form:input>
        </div>

        <div class="form-control">
            <!--
                -> not need everything an expense has
                -> path of whatever attribute I am setting
            -->
            <form:label path="description">Description: </form:label>
            <!-- want errors to show -->
            <form:errors class="text-danger" path="description"></form:errors>
            <form:input path="description"></form:input>
        </div>

        <input type="submit" value="Create An Expense">
    </form:form>

</body>
</html>
