<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-eqiv="Content-type" content="text/html; charset=ISO-8859-1">
<title>Category </title>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<style>
body{ 
background-image: url(resources/images/bgk13.jpg); 
background-size:     cover;                      
    background-repeat:   no-repeat;
 } 
 th{
    color:white;
    background-color:#F0F8FF;
    align:center;
}

table, th, td {
    border: 2.5px solid black;
    align:center;
   
    
}
/* .btn {
    background-color:#cc0052 ;
    } */
h2{
color:#F5F5DC;
font-family: "Times New Roman", Times, serif;
}

h3{
color:#F5F5DC;
font-family: "Times New Roman", Times, serif;
}


</style>
</head>
<body >
<nav class="navbar navbar-inverse" style="margin: 20px 0px 0px 0px;background-color:#20B2AA">
  <div class="container-fluid">
    <div class="navbar-header">
      <h2 class="navbar-brand" style="color:#F5F5DC;margin:5px 0px 0px 0px">FURNITURES</h2>
    </div>
    <ul class="nav navbar-nav">
      <li><a style="color:#F5F5DC;margin:5px 0px 0px 0px" href="admin"><span class="glyphicon glyphicon-home"></span></a></li>
     
     </ul>
      <ul class="nav navbar-nav" style="text-align:center">   
       <li><h1 style="color:#F5F5DC;margin:5px 0px 0px 400px" ><center>SUPPLIERS</center></h1></li>
           		
	 </ul>
     <ul class="nav navbar-nav navbar-right">       
      <li class="divider-vertical"></li>
		<c:if test="${pageContext.request.userPrincipal.name != null}"> 		
			  <li><h4 class="text-right" style="color:#F5F5DC;margin:20px 0px 0px 0px">HELLO, ${pageContext.request.userPrincipal.name}</h4></li>
			<li><a  style="color:#F5F5DC;margin:5px 0px 0px 0px" href="<c:url value="/j_spring_security_logout" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
		</c:if>    
								
     </ul>     
  </div>
</nav>

<div class="container-fluid" style="align:center; margin: 40px 0px 0px 150px">
<div class="col-md-4">
  <div class="row-fluid">
   <div class="span12">
   

<h2><center>ADD SUPPLIER</center></h2>
<c:url var="addAction"  value="/supplier/add"></c:url>

<%-- form:form action="${addAction }" commandName="supplier"--%>
<form:form method="POST" commandName="Supplier" action="supplier/add">
<table class="table table-condensed">
	<tr bgcolor=#F0F8FF>
		<td><form:label style="color:#000000" path="sid"><spring:message text="ID"/></form:label></td>
		
		
		<c:choose>
			<c:when test="${!empty supplier.sid }">
				<td><form:input style="background-color:#F5F5DC;border:0.25px solid black" path="sid" disabled="true" readonly="true"/></td>
			</c:when>
			<c:otherwise>
				<td><form:input style="background-color:#F5F5DC;border:0.25px solid black" path="sid"  pattern=".{4,7}" required="true" title="id should be between 4 to 7 characters"/></td>
				</c:otherwise>
				</c:choose>
				</tr>
				
				<tr bgcolor="#F0F8FF"> 
				<form:input path="sid" hidden="true"/>
				
				<td><form:label style="color:#000000" path="sname"> <spring:message text="NAME"/></form:label></td>
        		<td><form:input style="background-color:#F5F5DC;border:0.25px solid black" path="sname" required="true" /></td> 
				</tr>
				
				<tr bgcolor="#F0F8FF">
				<td><form:label style="color:#000000" path="sphonenumber" ><spring:message text="PHONENUMBER"/></form:label></td>
				<td><form:input style="background-color:#F5F5DC;border:0.25px solid black" path="sphonenumber" required="true"/></td>
				</tr>
				
					<tr bgcolor="#F0F8FF">
				<td><form:label style="color:#000000" path="saddress" ><spring:message text="ADDRESS"/></form:label></td>
				<td><form:input style="background-color:#F5F5DC;border:0.25px solid black" path="saddress" required="true"/></td>
				</tr>
				
				<tr bgcolor="#F0F8FF">
				<td align="right" colspan="2"><c:if test="${!empty supplier.sname }">
									<input style= "align:middle" class="btn btn-primary btn-md" type="submit" value="<spring:message text="Edit Supplier"/>"/>
								</c:if>
								<c:if test="${empty supplier.sname }">
									<input style= "align:middle"  class="btn btn-primary btn-md" type="submit" value="<spring:message text="Add Category"/>"/>
								</c:if>
				</td>
				</tr>
</table>
</form:form>
</div>
	</div>
	</div>
	</div>
<br>
<div class="container">

<h3><center>SUPPLIER LIST</center></h3>
<br>
<c:if test="${!empty supplierList}">
	<table  class="table" align="center" bordercolor="#800080" BORDER=10>
			<tr bgcolor="#F0F8FF">
				<th style="color:black" width="125" bgcolor="#F0F8FF" align="center">SUPPLIER ID</th>
				<th style="color:black" width="125" align="center">SUPPLIER NAME</th>
				<th style="color:black" width="190" align="center">SUPPLIER PHONENUMBER</th>
					<th style="color:black" width="190" align="center">SUPPLIER ADDRESS</th>
				<th style="color:black" width="100" align="center">EDIT</th>
				<th style="color:black" width="100" align="center">DELETE</th>
			</tr>
					<c:forEach items="${supplierList}" var="supplier">
				<tr bgcolor="#FFFFFF">
					<td  style="color:#000000;font-size:120%" align="center">${supplier.sid}</td>
					<td  style="color:#000000;font-size:120%" align="center">${supplier.sname}</td>
					<td style="color:#000000;font-size:120%" align="center">${supplier.sphonenumber}</td>
					<td  style="color:#000000;font-size:120%" align="center">${supplier.saddress}</td>
					<td style="color:#000000;font-size:120%" align="center"><a href="<c:url value='supplier/edit/${supplier.sid}' />"><button type="button" class="btn btn-warning">Edit</button></a></td>
					<td style="color:#000000;font-size:120%" align="center"><a href="<c:url value='supplier/remove/${supplier.sid}' />"><button type="button" class="btn btn-danger">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>





</body>
</html>