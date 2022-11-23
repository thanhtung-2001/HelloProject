<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div id="container" style="text-align: right">
    <a href="login-form.jsp">User</a>
</div>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="NhaXuatBan">List NXB</a>
<a href="Books">List Book</a>
<a href="TheLoais">List The Loai</a>
<a href="">List Cua Hang</a>
<%--<form action="hello-servlet" method="get">--%>
<%--    <label>So A</label><input type="text" name="soa"><br/>--%>
<%--    <label>So B</label><input type="text" name="sob"><br/>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>
</body>
</html>