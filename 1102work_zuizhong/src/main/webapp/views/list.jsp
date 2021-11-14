<%@ page import="com.dzqc.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jzh
  Date: 2021/11/14
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>用户列表</title>
</head>
<body>
这里是用户列表页面
<a href="<%=request.getContextPath()%>/views/edit.jsp">修改</a>
<a href="<%=request.getContextPath()%>/views/remove.jsp">删除</a>
<table>
    <thead>
    <th style="width: 60px">id</th>
    <th style="width: 150px;">username</th>
    <th style="width: 200px;">email</th>
    <th style="width: 60px;">userType</th>
    </thead>
<tbody>
<%--${users}--%>
<%--<c:forEach var="u" items="100">--%>
<%--    <tr>--%>
<%--        <td>1</td>--%>
<%--    </tr>--%>
    <%--    <tr>--%>
    <%--        <td>${u.id}</td>--%>
    <%--        <td>${u.userName}</td>--%>
    <%--        <td>${u.email}</td>--%>
    <%--        <td>${u.userType}</td>--%>
    <%--    </tr>--%>

<%--</c:forEach>--%>

<%
    List<User> users = (List<User>) request.getAttribute("users");%>
<% for (int i = 0; i < users.size(); i++) {%>
<tr>
    <td><%= users.get(i).getId() %></td>
    <td><%= users.get(i).getUserName() %></td>
    <td><%= users.get(i).getEmail() %></td>
    <td><%= users.get(i).getUserType() %></td>
</tr>
<% } %>
</tbody>
</table>
</body>
</html>
