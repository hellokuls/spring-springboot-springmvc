<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/27
  Time: 1:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 clumn">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>

    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <input name="bookID" hidden="hidden" value="${Qbook.bookID}">
        <div class="form-group">
            <label for="bookname">书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${Qbook.bookName}" id="bookname">
        </div>
        <div class="form-group">
            <label for="bookcounts">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${Qbook.bookCounts}" id="bookcounts">
        </div>
        <div class="form-group">
            <label for="bookdetails">书籍描述</label>
            <input type="text" name="details" class="form-control" value="${Qbook.details}" id="bookdetails">
        </div>
        <div class="form-group">

            <input type="submit" class="form-control" value="修改">
        </div>

    </form>



</div>
</body>
</html>
