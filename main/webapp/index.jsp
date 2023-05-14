<%@page import="com.Db.*" %>
<%@page import="java.sql.*" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<style type="text/css">
.back-img {
	background-image:url("images/bgimg1.jpg");
	width:100%;
	height:865px;
	background-size: cover;
	background-repeat: no-repeat;
	min-height:100%;
	text-align:center;
	
}



</style>
<link rel="stylesheet" href="style/style.css">
<meta charset="UTF-8">
<title>Home Page- E-notes</title>
<%@include file="components/allcssfile.jsp"%>
</head>
<body >
	<%@include file="components/navbar.jsp"%>
	
	<div class="back-img" >
	
	<h1 
	style="color:black;
    padding-top: 227px;
	" ><i class="fa fa-book mx-2"></i>E-Notes Save Your Notes</h1>
	
        <a class="btn btn-outline-dark mx-2 " href="login.jsp" type="submit" style=font-size:20px;margin-top:33px> <i class="fa fa-sharp fa-solid fa-user-plus mx-2"></i>Login</a>
          <a class="btn btn-outline-dark mx-2 " href="register.jsp" type="submit" style=font-size:20px;margin-top:33px><i class="fa fa-solid fa-address-card mx-2"></i>Register</a>
   </div>
	<%@include file="footer.jsp" %>
	
</body>
</html>