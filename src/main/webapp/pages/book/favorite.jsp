<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/23
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>收藏夹</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/favorite.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
<%--    <script type="text/javascript" src="static/script/detail.js"></script>--%>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <div class="fav-frame">
            <div class="fav-title">收藏夹</div>
            <div class="fav-box">
                <div class="fav-book">
                    <div class="fav-data">
                        <img class="fav-img" alt="" src="">
                        <p>恋恋世界第一！</p>
                        <p>刘阿伟</p>
                    </div>
                    <div class="fav-bottom">
                        <span>收藏于：</span>
                        <p>2022-05-14</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
<%--<table style="collapse: 0">--%>
<%--    <tr>--%>
<%--        <th>图书编号</th>--%>
<%--        <th>书名</th>--%>
<%--        <th>作者</th>--%>
<%--        <th>译者</th>--%>
<%--        <th>收藏时间</th>--%>
<%--        <th>查看详情</th>--%>
<%--        <th>取消收藏</th>--%>
<%--        <th>立刻下载</th>--%>
<%--    </tr>--%>
    <c:forEach items="${requestScope.userFavoritesList}" var="favorite">
        <tr>
            <td>${favorite.bookId}</td>
            <td>${favorite.title}</td>
            <td>${favorite.author}</td>
            <td>${favorite.translator}</td>
            <td>${favorite.collectTime}</td>
            <td><a href="bookServlet?action=showBookDetailsById&bookId=${favorite.bookId}">查看详情</a></td>
            <td><a href="favoriteServlet?action=deleteFavorite&userId=${sessionScope.user.id}&bookId=${favorite.bookId}">取消收藏</a>
            </td>
            <td><a href="transferServlet?action=downloadBook&id=${favorite.bookId}">立刻下载</a></td>
        </tr>
    </c:forEach>
<%--</table>--%>
</body>
</html>
