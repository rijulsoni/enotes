<%@page import="com.User.*" %>
<nav class="navbar navbar-expand-lg navbar-custom " style="background-color:#5e35b1;">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp" style="color:white;font-size:20px"><i class="fa fa-book mx-2"></i>E-Notes</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       <li class="nav-item">
          <a class="nav-link " href="home.jsp"> <i class="fa-solid fa-house mx-2"></i>Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="addNotes.jsp"><i class="fa-solid fa-circle-plus mx-2"></i>Add Notes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="showNotes.jsp"><i class="fa-solid fa-address-book mx-2"></i>Show Notes</a>
        </li>
      
      </ul>
     <%
    UserDetails user=(UserDetails) session.getAttribute("UserD");
       if(user!=null){
    	   %>
    	    <a  data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-outline-light mx-2" href="" type="submit" style=font-size:20px;> <i class="fa-solid fa-user mx-2"></i><%= user.getName()%></a>
          <a class="btn btn-outline-light" href="logoutServlet"  type="submit" style=font-size:20px;><i class="fa fa-light fa-right-from-bracket mx-2"></i>Logout</a>
   <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <div class="text-center">
      <i class="fa-solid fa-user fa-2xl"></i>
        <table class="table">

  <tbody>
   <tr>
    <th>User ID</th>
    <td><%=user.getId() %></td>
    </tr>
    <tr>
    <th>User Name</th>
    <td><%=user.getName() %></td>
    </tr>
     <tr>
    <th>Email Id</th>
    <td><%=user.getEmail() %></td>
    </tr>
  </tbody>
</table>

        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       
   
      </div>
     
    </div>
  </div>
</div>
  </div>
    <%  }
       else{
    	   %>
    	    <a class="btn btn-outline-light mx-2" href="login.jsp" type="submit" style=font-size:20px;> <i class="fa fa-sharp fa-solid fa-user-plus mx-2"></i>Login</a>
          <a class="btn btn-outline-light" href="register.jsp"  type="submit" style=font-size:20px;><i class="fa fa-solid fa-address-card mx-2"></i>Register</a>
   
       1<% }%>
       
    </div>
    </div>




  

</nav>