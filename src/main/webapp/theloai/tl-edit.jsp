<%@ page import="com.fpt.edu.model.TheLoai" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 21/11/2022
  Time: 7:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> EDIT </h2>
<% TheLoai theLoai = (TheLoai) request.getAttribute("theLoai"); %>

<form action="TheLoaiController" method="post">
    <input type="hidden" name="id" value="<%= theLoai.getId() %>">
    <input type="hidden" name="method" value="update">
    <label>Ten</label><input type="text" name="ten" value="<%= theLoai.getTen() %>"><br/>
    <input type="submit" name="Submit">
</form>
</body>
</html>
