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

    <%-- 图书添加到收藏夹提示信息 --%>
    <c:if test="${not empty sessionScope.addFavoriteMsg}">
        <script type="text/javascript">alert("${sessionScope.addFavoriteMsg}")</script>
        <% session.removeAttribute("addFavoriteMsg"); %>
    </c:if>
    <%-- 图书收藏夹取消收藏提示信息 --%>
    <c:if test="${not empty sessionScope.deleteFavoritesMsg}">
        <script type="text/javascript">alert("${sessionScope.deleteFavoritesMsg}")</script>
        <% session.removeAttribute("deleteFavoritesMsg"); %>
    </c:if>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <div class="fav-frame">
            <div class="fav-title">收藏夹</div>
            <div class="fav-box">
                <c:forEach items="${requestScope.userFavoritesList}" var="favorite">
                    <div class="fav-book">
                        <a title="取消收藏"
                           href="favoriteServlet?action=deleteFavorite&userId=${sessionScope.user.id}&bookId=${favorite.bookId}"
                           class="fav-close">
                            <img class="fav-close-img" src="static/img/icon_close_d.png" alt="取消收藏">
                        </a>
                        <div class="fav-data">
                            <a title="查看详情" href="bookServlet?action=showBookDetailsById&bookId=${favorite.bookId}">
                                    <%--                                // TODO 等待修改 Favorite POJO 类，添加封面属性，删除译者属性 --%>
                                <img class="fav-img" src="static/img/Cirno.jpg" alt="封面加载失败">
                            </a>
                            <p class="fav-bk-t">${favorite.title}</p>
                            <p class="fav-author">${favorite.author}</p>
                            <a title="立即下载" class="fav-download"
                               href="transferServlet?action=downloadBook&id=${favorite.bookId}">立即下载</a>
                        </div>
                        <div class="fav-bottom">
                            <span>收藏于：</span>
                            <p>${favorite.collectTime}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
<%--</table>--%>
</body>
</html>
