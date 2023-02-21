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
    <div class="container center">
        <div class="d-flex justify-content-between">
            <h1 class="text-center">Edit Expense</h1>
            <a href="/">Go Back</a>
        </div>
        <!--
            -> form that is going to let me add an expense
            -> action -> the tourte that is going to handle this form data
                !-> remember to use restful routing convention
            -> if using form:form have to add modelAttribute -> traditional form do not
                -> do not use a traditional form
            -> form:form is easier to do with validations
        -->
        <form:form class="container center" action="/expenses/${expense.id}" method="post" modelAttribute="expense">
            <input type="hidden" name="_method" value="put">
            <div class="form-control">
                <!-- ~to use the model attribute
                    -> form:form tags
                    -> built into jsp
                    -> prepopulate forms when editing
                    -> access the actual object itself when creating an instance
                    -> leveraging the power of jsp and jpa to be able to add forms using the sprinf framework resources we have
                -->
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
            <input type="submit" value="Edit Expense">
        </form:form>
    </div>

</body>
</html>
