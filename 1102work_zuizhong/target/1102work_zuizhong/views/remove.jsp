<%--
  Created by IntelliJ IDEA.
  User: jzh
  Date: 2021/11/14
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user" method="post">
<input name="todo" value="del" style="display: none">
用户名：<input name="uname" id="uname" type="text">
<br/>


<input type="submit" value="删除">
</form>
</body>
</html>
