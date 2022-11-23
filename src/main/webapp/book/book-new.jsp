<%@ page import="com.fpt.edu.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 14/11/2022
  Time: 8:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Them moi sach</title>
</head>
<body>
<%
    List<Book> list = (List<Book>) request.getAttribute("listbook");
%>
<form method="post" action="Books">
    <input type="hidden" name="method" value="add">
    <label>Ten</label><input type="text" name="ten"><br>
    <label>Tac Gia</label><input type="text" name="tacgia"><br>
    <label>The Loai</label>
    <select name="theloai_id">
        <c:forEach var="tl" items="${listtheloai}">
            <option value="${tl.id}">${tl.ten}</option>
        </c:forEach>
    </select>
    <br>
    <label>Nha Xuat Ban</label>
    <select name="nxb_id">
        <c:forEach var="nxb" items="${listnxb}">
            <option value="${nxb.id}">${nxb.ten}</option>
        </c:forEach>
    </select>
    <br>
    <label>Gia Ban</label><input type="text" name="giaban"><br>
    <hr>
    <input type="submit" value="submit">
</form>
</body>
</html>
