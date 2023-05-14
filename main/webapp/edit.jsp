<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.DAO.postDAO" %>
       <%@page import="com.User.Post.*" %>
 
       <%@page import="com.Db.*" %>
    <% UserDetails user1=(UserDetails)session.getAttribute("UserD");
if(user1==null){
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error","Please Login");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Notes</title>
<link rel="stylesheet" href="style/style.css">
<%@include file="components/allcssfile.jsp"%>
</head>
<body><%@include file="components/navbar.jsp"%>
<% Integer noteid=Integer.parseInt(request.getParameter("note_id"));
postDAO post=new postDAO(DBConnect.getConn());
Post p=post.getDataById(noteid);%>
	
	<div class="container" style="min-height: 600px; height: 100%;">
		<div class="row">
			<div class="col-md-12">
				<form action="EditNotesServlet" method="post" >
					
					<h1 class="text-center pt-5">EDIT YOUR NOTES</h1>
					<input type="hidden" value="<%=noteid%>" name="noteid">
						
					<div class="form-group my-2">
						
						<label for="inputTitle my-1">Edit Title</label>
						<input type="text" class="form-control" id="inputTitle" aria-describedby="emailHelp"
							placeholder="Edit Title Of Your Note" name="title" value="<%=p.getTitle()%>">
					</div>
					<div class="form-group  my-2">
						<label for="noteContent my-1">Edit Content</label>
						<textarea rows="12" cols="" class="form-control" id="noteContent"
							placeholder="Edit Content Of Your Note" name="content" ><%=p.getContent()%></textarea>
					</div>
				
				
					<div class="text-center">
						<button type="submit" class="btn btn-primary my-2">EDIT NOTES</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>