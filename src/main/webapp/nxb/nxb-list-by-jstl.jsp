<%--
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
    <title>Danh sach nha xuat ban</title>
</head>
<body>
<c:if test="${!empty(sessionScope.get('user'))}">
    <a href="NhaXuatBan?method=new"><button>Them</button></a>
    <hr>
</c:if>
<c:if test="${!empty(listnxb)}">
    <c:forEach var = "nxb" items="${listnxb}">
        <c:out value = "${nxb.id}"/> - <c:out value="${nxb.ten}"></c:out>
        <a href="NhaXuatBan?method=edit&nxb_id=${nxb.getId()}"><button>Sua</button></a>
        <a href="NhaXuatBan?method=delete&nxb_id=${nxb.getId()}"><button>Xoa</button></a>
        <br/>
    </c:forEach>
</c:if>

<c:if test="${empty(listnxb)}">
    <h4>Khong co nha xuat ban</h4>
</c:if>
</body>
</html>
