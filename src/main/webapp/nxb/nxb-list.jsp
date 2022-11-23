<%@ page import="java.util.List" %>
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
<h2>Trang danh sach nha xuat ban</h2>
<a href="nxb-form.jsp"><button>Them</button></a>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>ten</th>
            <th>di chi</th>
            <th>so dien thoai</th>
            <th>so fax</th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
    <%
        List<NhaXuatBan> list = (List<NhaXuatBan>) request.getAttribute("listnxb");
        for(NhaXuatBan n: list){
    %>
        <tr>
            <td><%= n.getId()%> </td>
            <td><%= n.getTen()%> </td>
            <td><%= n.getDiachi()%> </td>
            <td><%= n.getSdt()%> </td>
            <td><%= n.getSofax()%> </td>
            <td>
                <a href="NhaXuatBan?method=detail&nxb_id=<%= n.getId()%>"><button>Chi Tiet</button></a>
                <a href="NhaXuatBan?method=edit&nxb_id=<%= n.getId()%>"><button>Sua</button></a>
                <a href="NhaXuatBan?method=delete&nxb_id=<%= n.getId()%>"><button>Xoa</button></a>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="NhaXuatBan?method=new"><button>Them</button></a>
</body>
</html>
