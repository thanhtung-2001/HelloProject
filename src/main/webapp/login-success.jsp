<%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 14/11/2022
  Time: 8:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.fpt.edu.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user =  ((User)session.getAttribute("user")); %>
<h1>
    <% if(null!= user) {%>
    Login Success By <%= user.getUsername() %>
    <a class="nav-link dropdown-toggle px-1" data-bs-toggle="dropdown" title="Manage">
        <span class="d-none d-lg-inline-flex"><%= user.getUsername() %></span>
    </a>
    <div class="dropdown-menu ">
        <a class="dropdown-item text-dark">Profile</a>
        <a class="dropdown-item text-dark">Manage Email</a>
        <a class="dropdown-item text-dark">Change password</a>
        <a class="dropdown-item text-dark">Two-factor authentication</a>
        <a class="dropdown-item text-dark">Personal Data</a>
        <form  class="dropdown-item" >
        <button  type="submit" class="nav-link btn btn-link text-dark">Log Out</button>
        </form>
    </div>
    <% //session.removeAttribute("user"); %>
    <% } else{ %>
    Ban khong co quyen truy cap den trang nay
    <%}%>
    <br>
    <a href="index.jsp">Back</a>
</h1>
</body>
</html>
