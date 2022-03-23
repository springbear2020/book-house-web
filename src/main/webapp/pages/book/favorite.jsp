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
    <title>收藏夹</title>
</head>
<body>
<table style="collapse: 0">
    <tr>
        <th>图书编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>译者</th>
        <th>收藏时间</th>
        <th>查看详情</th>
        <th>取消收藏</th>
        <th>立刻下载</th>
    </tr>
    <%--    // TODO 样式呐，前端，阿伟，快来--%>
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
</table>
</body>
</html>
