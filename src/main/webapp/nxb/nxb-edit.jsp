<%@ page import="com.fpt.edu.model.NhaXuatBan" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 14/11/2022
  Time: 8:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Chinh Sua Nha Xuat Ban
<% NhaXuatBan nhaXuatBan = (NhaXuatBan) request.getAttribute("nhaXuatBan"); %>

<form action="NhaXuatBan" method="post">
    <input type="hidden" name="id" value="<%= nhaXuatBan.getId() %>">
    <input type="hidden" name="method" value="update">
    <label>Ten</label><input type="text" name="ten" value="<%= nhaXuatBan.getTen() %>"><br>
    <label>Dia Chi</label><input type="text" name="diachi" value="<%= nhaXuatBan.getDiachi() %>"><br>
    <label>So Dien Thoai</label><input type="text" name="sdt" value="<%= nhaXuatBan.getSdt() %>"><br>
    <label>So Fax</label><input type="text" name="sofax"value="<%= nhaXuatBan.getSofax() %>"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
