<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% UserDetails user1=(UserDetails)session.getAttribute("UserD");
if(user1==null){
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error","Please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Your Notes</title>
<link rel="stylesheet" href="style/style.css">
<%@include file="components/allcssfile.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container" style="min-height: 600px; height: 100%;">
		<div class="row">
			<div class="col-md-12">
				<form action="AddNotesServlet" method="post" enctype="multipart/form-data">
					<h1 class="text-center pt-5">ADD YOUR NOTES</h1>
					<%
						UserDetails us = (UserDetails) session.getAttribute("UserD");
					if(us!=null)
					{%>
						
						<input type="hidden" value="<%=us.getId()%>" name="uid">
					<%}
					
						%>
						
					<div class="form-group my-2">
						
						<label for="inputTitle my-1">Enter Title</label>
						<input type="text" class="form-control" id="inputTitle" aria-describedby="emailHelp"
							placeholder="Enter Title Of Your Note" name="title">
					</div>
					<div class="form-group  my-2">
						<label for="noteContent my-1">Note Content</label>
						<textarea rows="12" cols="" class="form-control" id="noteContent"
							placeholder="Enter Content Of Your Note" name="content"></textarea>
					</div>
					<div class="form-group  my-2">
						<label for="noteContent my-1">Upload Files</label>
						<input type="file" multiple name="file" accept=".pdf">
					</div>
				
					<div class="text-center">
						<button type="submit" class="btn btn-primary my-2">ADD NOTES</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
