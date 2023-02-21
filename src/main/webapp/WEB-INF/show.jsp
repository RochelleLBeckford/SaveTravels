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
            <h1 class="text-center">Expense Details</h1>
            <a href="/">Go Back</a>
        </div>
        <!--
            -> for loop -> make a table to display all expense
        -->
        <table class="table container center table-hover text-center table-striped">
            <thead>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Description</th>
            </thead>
            <tbody>
            <!-- do not need C:out when using Model model -->
            <tr>
                <!--
                    -> can interate through and list all my expenses
                    -> Java equivalent of Jinja
                -->
                <td>${expense.expenseName}</td>
                <td>${expense.vendor}</td>
                <td>${expense.amount}</td>
                <td>${expense.description}</td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
