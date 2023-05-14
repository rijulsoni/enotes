<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="com.User.*" %>
   <% UserDetails user2=(UserDetails)session.getAttribute("UserD");
if(user2==null){
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error","Please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/style.css">
<%@include file="components/allcssfile.jsp"%>
<meta charset="UTF-8">
<title>Start Taking Notes</title>
</head>
<body>
<%@include file="components/navbar.jsp"%>
<div class="container-fluid p-0">
<div class="card py-5">
<div class="card-body text-center">
<img style="height:400px" src="https://www.wikihow.com/images/thumb/1/18/Take-Better-Notes-Step-1-Version-2.jpg/aid11032-v4-728px-Take-Better-Notes-Step-1-Version-2.jpg.webp" class="img-fluid mx-auto"/>
<h1>Start Taking Your Notes</h1>
<a href="addNotes.jsp" class="btn btn-outline-secondary">Start Here</a>
</div>
</div>
</div>


	<%@include file="footer.jsp" %>
</body>
</html>