<%--
  Created by IntelliJ IDEA.
  User: Thanh Tùng
  Date: 18/11/2022
  Time: 8:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${!empty(sessionScope.get('user'))}">
    <a href="TheLoais?method=new"><button>Them</button></a>
    <hr>
</c:if>
<c:if test="${!empty(listtheloai)}">
    <c:forEach var = "tl" items="${listtheloai}">
        <c:out value = "${tl.id}"/> - <c:out value="${tl.ten}"></c:out>
        <a href="TheLoais?method=edit&tl_id=${tl.getId()}"><button>Sua</button></a>
        <a href="TheLoais?method=delete&tl_id=${tl.getId()}"><button>Xoa</button></a>
        <br/>
    </c:forEach>
</c:if>

<c:if test="${empty(listtheloai)}">
    <h4>Khong co the loai</h4>
</c:if>
</body>
</html>
