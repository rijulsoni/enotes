<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <%@ page import="com.User.Post" %>
  <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Posts</title>
</head>
<body>
    <h1>Posts</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Content</th>
                <th>Download</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<Post> posts = (List<Post>) request.getAttribute("posts");
            for (Post post : posts) {
                %>
                <tr>
                    <td><%= post.getId() %></td>
                    <td><%= post.getTitle() %></td>
                    <td><%= post.getContent() %></td>
                    <td><%= post.getDownloadLink() %></td>
                </tr>
                <%
            }
            %>
        </tbody>
    </table>
</body>
</html>
