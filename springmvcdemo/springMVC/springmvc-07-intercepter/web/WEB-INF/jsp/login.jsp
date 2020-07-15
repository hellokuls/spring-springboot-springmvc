<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/28
  Time: 10:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/user/login">

用户名：<input name="username" type="text">
密码：<input name="password" type="text">
<input type="submit" value="登录">

</form>
</body>
</html>
