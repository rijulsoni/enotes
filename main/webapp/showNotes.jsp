<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.DAO.*" %>
     <%@ page import="com.Db.*" %>
   <%@ page import="com.DAO.postDAO" %>
   
<%@ page import="java.util.List" %>
<%@ page import="com.User.Post" %>
<%@page import="java.util.Base64" %>
    <% UserDetails user3=(UserDetails)session.getAttribute("UserD");
if(user3==null){
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error","Please Login");
}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
</head>
<link rel="stylesheet" href="style/style.css">
<%@include file="components/allcssfile.jsp"%>
<body>
<%@include file="components/navbar.jsp"%>
<% String updated=(String)session.getAttribute("update-data");
if(updated!=null)
{%> <div  class="alert alert-success alert-dismissible fade show" role="alert">
<%= updated%>
<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

	<% session.removeAttribute("update-data");
	}
%>
<% String deleted=(String)session.getAttribute("Error-Delete-Notes");
if(deleted!=null)
{%> <div  class="alert alert-danger alert-dismissible fade show" role="alert">
<%=deleted%>
<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

	<% session.removeAttribute("Error-Delete-Notes");
	} 
%>
<div class="container">
<h2 class="text-center mt-4">All Notes:</h2>
<div class="row">
<div class="col-md-12">
<%
if(user3!=null){
	postDAO o=new postDAO(DBConnect.getConn());
	List<Post> post =o.getData(user3.getId()); 
	for(Post po:post){%>
		<div class="card mt-3">
		<img src="https://i.pinimg.com/564x/52/8e/29/528e2946f76a74030660b231c7ff1dc1.jpg" class="card-img-top mt-2 mx-auto" style="max-width:100px;">
		<div class="card-body p-4">

		<h5 class="card-title"><%=po.getTitle() %></h5>
		<p><%=po.getContent() %></p>
		<p>
		<b class="text-success">Published By:<%=user3.getName() %></b></br>
		<b class="text-success">Published Date:<%=po.getPdate() %></b></br></p>
		<div class="container text-center mt-2">
		<a href="pdfdownload.jsp" class="btn btn-primary">Download PDF</a></div>
		
		
		<div class="container text-center mt-2">
		<a href="edit.jsp?note_id=<%= po.getId()%>" class="btn btn-primary">Edit Notes</a>
		<a href="deleteServlet?note_id=<%=po.getId()%>" class="btn btn-danger">Delete Notes</a>
		</div>
		</div>
		</div>
	<% }
}
%>
</div>
</div>
</div>
</body>
</html>