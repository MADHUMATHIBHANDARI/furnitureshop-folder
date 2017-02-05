<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body
{
background-image:"/resources/images/f1.jpg";
}
</style>
<body>
<div class="container">
  <center><h2>Sign Up Form</h2></center>
  <form:form method="POST" commandName="user" action="register/add">
   <div class="form-group">
    <label for="name"> Name:</label>
    <form:input type="text" class="form-control" id="name" placeholder="Enter Name" path="name"/>
       </div><br><br>
    <div class="form-group">
     <label for="password">Password:</label>
     <form:input type="password" class="form-control" id="pwd" placeholder="Enter password" path="password"/>
    </div><br><br>   
    <div class="form-group">
      <label for="address">Address:</label>
      <form:input type="text" class="form-control" id="address" placeholder="Enter address" path="address"/>
    </div><br><br>
      <div class="form-group">
      <label for="email">Email:</label>
      <form:input type="text" class="form-control" id="email" placeholder="Enter email" path="email"/>
    </div><br><br>
    <div class="form-group">
      <label for="phno">Phonenumber:</label>
      <form:input type="text" class="form-control" id="phno" placeholder="Enter phonenumber" path="phonenumber"/>
    </div><br><br>
   
    <button type="register" class="btn btn-primary">Register</button>
  </form:form>
</div>




</body>
</html>