<%@ page import="com.fpt.edu.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 16/11/2022
  Time: 8:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sua sach</title>
</head>
<body>
Chinh Sua Sach
<% Book book = (Book) request.getAttribute("book"); %>

<form action="Books" method="post">
    <input type="hidden" name="id" value="<%= book.getId() %>">
    <input type="hidden" name="method" value="update">
    <label>Ten</label><input type="text" name="ten" value="<%= book.getTen() %>"><br/>
    <label>Tac Gia</label><input type="text" name="tacgia" value="<%= book.getTacgia() %>"><br/>
    <label>The Loai</label>
    <select name="theloai_id">
        <c:forEach var="tl" items="${listtheloai}">
            <c:choose>
                <c:when test="${book.theloai_id == tl.id}">
                    <option value="${tl.id}" selected>${tl.ten}</option>
                </c:when>
                <c:otherwise><option value="${tl.id}">${tl.ten}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <br>
    <label>Nha Xuat Ban</label>
    <select name="nxb_id">
        <c:forEach var="nxb" items="${listnxb}">
            <c:choose>
                <c:when test="${book.nxb_id == nxb.id}">
                    <option value="${nxb.id}" selected>${nxb.ten}</option>
                </c:when>
                <c:otherwise><option value="${nxb.id}">${nxb.ten}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <br>
    <label>Gia Ban</label><input type="text" name="giaban" value="<%= book.getGiaban() %>"><br/>
    <input type="submit" name="Submit">
</form>
</body>
</html>
