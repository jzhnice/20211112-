<%--
  Created by IntelliJ IDEA.
  User: jzh
  Date: 2021/11/14
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/reg" method="post">

    用户名：<input name="uname" id="uname" type="text">
    <br/>
    邮箱：<input name="email" id="email" type="email">
    <br/>
    密码：<input name="pwd" id="pwd" type="password">
    <br/>
    <input type="submit" value="注册">
    <br/>


</form>
</body>
</html>
