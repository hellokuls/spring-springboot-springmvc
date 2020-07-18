<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kuls
  Date: 2020/3/27
  Time: 11:13 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有书籍</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 clumn">
            <div class="page-header">
                <h1>
                    <small>书籍列表------显示所有书籍</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 clumn">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toaddBook">增加书籍</a>
            </div>

            <div class="col-md-4 clumn"></div>
            <div class="col-md-4 clumn">

                <form class="form-inline" action="${pageContext.request.contextPath}/book/searchBook" method="post" style="float: right">
                    <span>${error}</span>
                    <input type="text" name="queryBookName" class="form-control">
                    <input type="submit" value="搜索" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 clumn">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍描述</th>
                    <th>基本操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <th>${book.bookID}</th>
                        <th>${book.bookName}</th>
                        <th>${book.bookCounts}</th>
                        <th>${book.details}</th>
                        <th>
                            <a href="${pageContext.request.contextPath}/book/toUpdateAddBook?id=${book.bookID}">修改</a>  &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


    </div>

</div>
</body>
</html>
