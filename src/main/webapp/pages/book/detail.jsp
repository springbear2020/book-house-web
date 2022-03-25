<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/22
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>图书详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/detail.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/detail.js"></script>

    <%-- 图书添加到收藏夹提示信息 --%>
    <c:if test="${not empty sessionScope.addFavoriteMsg}">
        <script type="text/javascript">alert("${sessionScope.addFavoriteMsg}")</script>
        <% session.removeAttribute("addFavoriteMsg"); %>
    </c:if>
    <%-- 下载图书提示信息 --%>
    <c:if test="${not empty sessionScope.downloadBookMsg}">
        <script type="text/javascript">alert("${sessionScope.downloadBookMsg}")</script>
        <% session.removeAttribute("downloadBookMsg"); %>
    </c:if>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-frame">
        <div class="book-inf">
            <div class="inf-left">
                <img src="${requestScope.book.coverPath}" class="book_img" alt="图片加载失败">
            </div>
            <ul class="inf-right">
                <li>
                    <div>编号</div>
                    <p>&nbsp;${requestScope.book.id}</p><span>显示</span></li>
                <li>
                    <div>书名</div>
                    <p>&nbsp;${requestScope.book.title}</p><span>显示</span></li>
                <li>
                    <div>作者</div>
                    <p>&nbsp;${requestScope.book.author}</p><span>显示</span></li>
                <li>
                    <div>译者</div>
                    <p>&nbsp;${requestScope.book.translator}</p><span>显示</span></li>
                <li>
                    <div>关键字</div>
                    <p>&nbsp;${requestScope.book.keywords}</p><span>显示</span></li>
                <li>
                    <div>下载量</div>
                    <p>&nbsp;${requestScope.book.downloads}</p><span>显示</span></li>
                <li>
                    <div>收藏量</div>
                    <p>&nbsp;${requestScope.book.collections}</p><span>显示</span></li>
                <li>
                    <div>图书评价</div>
                    <p id="book-commit">&nbsp;${requestScope.book.comment}</p><span>显示</span></li>
                <li>
                    <div>上传用户</div>
                    <p>&nbsp;${requestScope.book.uploadUsername}</p><span>显示</span></li>
                <li>
                    <div>上传时间</div>
                    <p>&nbsp;${requestScope.book.uploadTime}</p><span>显示</span></li>
                <a class="button-a btn-down"
                   href="transferServlet?action=downloadBook&bookId=${requestScope.book.id}&userId=${sessionScope.user.id}">立即下载</a>
                <a class="button-a btn-fav"
                   href="favoriteServlet?action=addFavorite&bookId=${requestScope.book.id}&userId=${sessionScope.user.id}&title=${requestScope.book.title}&author=${requestScope.book.author}&coverPath=${requestScope.book.coverPath}">收藏图书</a>
            </ul>
        </div>
    </div>
</div>
<a class="ToLeft" href="bookServlet?action=showBookRandomly"><img src="static/img/icon_left.png" alt="图片加载失败"></a>
<a class="ToRight" href="bookServlet?action=showBookRandomly"><img src="static/img/icon_right.png" alt="图书加载失败"></a>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>