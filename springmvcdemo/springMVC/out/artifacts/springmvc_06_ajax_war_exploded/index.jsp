<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/28
  Time: 8:23 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
  <script>
    function a(){
      $.post({
        url:"${pageContext.request.contextPath}/t2",
        data:{"name":$("#url").val()},
        success:function (data) {
          alert(data)
        }
      })
    }

  </script>
  <body>
<input id="url" type="text" onblur="a()">
  </body>
</html>
