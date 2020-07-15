<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/28
  Time: 9:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
<script>
    $(function() {
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/a1", function (data) {
                console.log(123123)
                var html ="";
                for (var i = 0; i < data.length; i++) {
                    html += "<tr>" +
                        "<td>"+data[i].name+"</td>"+
                        "<td>"+data[i].age+"</td>"+
                        "<td>"+data[i].sex+"</td>"+
                        "</tr>"
                }
                $("#context").html(html);
            })
        })
    })
</script>
<body>

<input id="btn" type="button" value="查询">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>

    <tbody id="context">

    </tbody>
</table>
</body>
</html>
