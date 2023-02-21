# Save Travels 
<!-- can have readme preview open as well to see how it will appear -->
<!-- - this is a bullet -->

<!-- ## this is a sub heading -->
### A friend of yours is going to Hawaii and is worried about their budget for the trip. To save them some time and worry, you've decided to build an app that they can use to help save and plan for special occasions.
- A Full-Stack, Full-CRUD application 

1. Create an app that keeps track of the user's expenses

2. The expense table should display the name of the expense, the name of the vendor, and the amount paid

3. Below the table, create a form that allows users to add expenses

4. Be sure to include the description field in your form (descriptions will only be visible on the Show and Edit pages)

5. Allow users to edit their entries

6. Allow users to delete their entries

7. Allow users to click on an expense in order to view its details

<!-- 
Test: Show how to add a web browser
[website](https://www.google.com) -->


 - ## Checklist
- [ ] update [application.properties](/src/main/resources/application.properties)
<!-- how to put in code blocks us ```-->
```
# Where are jsp files? HERE!
spring.mvc.view.prefix=/WEB-INF/
# Data Persistence
#<!-- after the '/' is <<WHATEVER_YOUR_SCHEMA_NAME>> that you created in MySQL Workbench -->
spring.datasource.url=jdbc:mysql://localhost:3306/save_travels
spring.datasource.username=root
spring.datasource.password=rootroot
spring.jpa.hibernate.ddl-auto=update
# For Update and Delete method hidden inputs
spring.mvc.hiddenmethod.filter.enabled=true
```


- ### After adding this to my pom fie it will ask if you want to update -> always say yes
- [ ] [pom.xml](pom.xml)
```
		<!-- 
		& add the two dependency files here 
		-> after save click yes so Maven can update the dependencies that we can use
		--> 

		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
		<dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
        </dependency>

		<!-- & Bootstrap -->
	    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>webjars-locator</artifactId>
        <version>0.30</version>
		</dependency>
		
		<!-- BOOTSTRAP DEPENDENCIES -->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.0.1</version>
		</dependency>
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.6.0</version>
		</dependency>

        <!-- & DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>

        <!-- & DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- & Bootswatch -->
		<dependency>
			<groupId>org.webjars.npm</groupId>
			<artifactId>bootswatch</artifactId>
			<version>5.2.3</version>
		</dependency>
```


- [ ] add [index.jsp](src/main/webapp/WEB-INF/index.jsp)
<!-- 
when you make this 
    -> can click it and vs code will say the file is not there 
    -> can create file
-> make sure in the right place -->
```
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

</body>
</html>

```
- [ ] add a schema in MySQL Workbench


<!-- 
-> Always generate the MainController by hand 
-> packages will differ for each directory 
-> this will make sure the file is in the right place
-->
- [ ] add controller [MainController.java](src/main/java/com/rochelle/save_travels/controllers/MainController.java)


- add this to the MainController.java
```
//MainController.java
    @Autowired ExpenseService expenseService;
```

- [ ] add model [Whatever.java](src/main/java/com/rochelle/save_travels/models/Expense.java)
    - To connect service with controller
        - [ ] add `@Entity` and `@Table` `@Id` `@GeneratedValue` to the model

<!-- need to add a service folder and file with whatever name you want -->
- [ ] add a [WhateverService.java](src/main/java/com/rochelle/save_travels/services/ExpenseService.java)

<!-- add service annotation -->
- add 
```
//ExpenseService.java
@Autowired ExpenseRepository expenseRepository;
```

<!-- need to add a repository folder and file with whatever name you want -->
- To connect service with repository
- [ ] add a [WhateverRepository.java](src/main/java/com/rochelle/save_travels/repositories/ExpenseRepository.java)


# SaveTravels
