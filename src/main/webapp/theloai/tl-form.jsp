<%@ page import="com.fpt.edu.model.TheLoai" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 18/11/2022
  Time: 8:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Them moi the loai</title>
</head>
<body>
<%
    List<TheLoai> list = (List<TheLoai>) request.getAttribute("listtheloai");
%>
<form method="post" action="TheLoais">
    <input type="hidden" name="method" value="add">
    <label>Ten</label><input type="text" name="ten"><br>
    <hr>
    <input type="submit" value="submit">
</form>
</body>
</html>
