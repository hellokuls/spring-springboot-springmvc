<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/28
  Time: 10:16 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<p>${username}</p>
<a href="${pageContext.request.contextPath}/user/goOUT">注销</a>
</body>
</html>
