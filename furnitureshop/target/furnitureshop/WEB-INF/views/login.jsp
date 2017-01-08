<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html >
<html>
<head>
<!-- <meta name="viewport" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1;width=device-width, initial-scale=1" > -->
<!-- <title>Insert title here</title>   -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body
{ 
background-image: url(resources/images/bgk19.jpg); 
background-size:     cover;                      
    background-repeat:   no-repeat;
 } 

</style>
<body>

   <div style="color:#000000;margin:40px 0px 0px 100px">
    <a style="color:#000000;font-size:2.0em" href="onLoad"><span class="glyphicon glyphicon-home"></span></a>
   </div>
   <div class="container" style="align:center; margin: 150px 0px 0px 150px">
   <div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-4 col-md-offset-3">
    
    <form  action="<c:url value='j_spring_security_check'/>"  method="POST" role="form">
       <c:if test="${not empty loginerror}">
       <p class="loginerror" >${loginerror}</p>
       </c:if>
       
       <c:if test="${not empty loginmsg}">
       <p class="loginmsg" >${loginmsg}</p>
       </c:if>
          <h2 style="color:#000000">Please Login</h2>
	     <hr class="colorgraph"> 
        <div class="row">
				<div class="col-sm-12 ">
					<div class="form-group">
						<input style="background-color:#FFFFE0" type="text"  name="username" id="name" class="form-control input-lg" placeholder="Name" tabindex="1" />
					</div>
				</div>
			
				
			</div>
			 <div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<input style="background-color:#FFFFE0" type="password"  name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="2" />
					</div>
				</div>
			
				
			</div>
			<hr class="colorgraph"> 
 			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Submit" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				
			</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			
        </form>
    
  
    </div>
   </div>
  </div>
    


</body>
</html>