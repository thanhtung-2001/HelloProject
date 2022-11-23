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
    <title>Danh Sach Sach</title>
</head>
<body>

<c:if test="${!empty(sessionScope.get('user'))}">
    <a href="Books?method=new"><button>Them</button></a>
    <hr/>
    User: ${user.username}
    <hr/>
</c:if>
<c:if test="${!empty(listbook)}">
    <c:forEach var = "book" items="${listbook}">
        <c:out value = "${book.id}"/>-<c:out value="${book.ten}"></c:out>-${book.nhaXuatBan.ten}-${book.giaban}
        <a href="Books?method=edit&book_id=${book.getId()}"><button>Sua</button></a>
        <a href="Books?method=delete&book_id=${book.getId()}"><button>Xoa</button></a>
        <br/>
    </c:forEach>
</c:if>

<c:if test="${empty(listbook)}">
    <h4>Khong co sach</h4>
</c:if>
</body>
</html>

