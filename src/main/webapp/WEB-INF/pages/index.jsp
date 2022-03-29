<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/20
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book House</title>
    <%@include file="/WEB-INF/pages/common/base.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/index.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/pages/common/header.jsp" %>
<div class="middle">
<%-- 搜索框表单 --%>
    <div class="search">
        <div class="search-container">
            <form class="search-form" method="post" action="book">
                <input type="hidden" name="action" value="showBooks">
                <label><input class="search-text" name="title" placeholder="请输入书名" value="${requestScope.title}"></label>
                <button type="submit" class="search-btn">搜索</button>
            </form>
        </div>
    </div>
    <%-- 显示图书数据 --%>
    <div class="row">
        <c:forEach items="${requestScope.bookPageData.pageData}" var="book">
            <div class="one-book">
                <div class="thumbnail">
                    <a href="book?action=showBookDetails&bookId=${book.id}" target="_blank"><img class="img-books" src="${book.coverPath}" alt=""></a>
                    <div class="caption">
                        <div><span class="book-id">${book.id}</span></div>
                        <div class="bk-t"><h5 class="book-title">《${book.title}》</h5></div>
                        <div class="book-data"><div class="book-download"><span>下载量</span><div>${book.downloads}</div></div><div class="book-collect"><span>收藏量</span><div>${book.collections}</div></div></div>
                        <div class="book-a"><a href="transfer?action=downloadBook&bookId=${book.id}&userId=${sessionScope.user.id}" class="a-download">下载</a><a href="record?action=addFavorite&bookId=${book.id}&userId=${sessionScope.user.id}&title=${book.title}&author=${book.author}&coverPath=${book.coverPath}" class="a-collect">收藏</a></div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div style="clear:both"></div>
    </div>
    <%-- 分页条 --%>
    <nav aria-label="Page navigation" class="pag-chs">
        <ul class="pagination">
            <%-- 总页数大于 1 才显示首页和上一页 --%>
            <c:if test="${requestScope.bookPageData.pageTotal > 1 && requestScope.bookPageData.pageNum != 1}">
                <li><a href="book?action=showBooks&title=${requestScope.title}" class="pag-num pag-fl">首页</a></li>
                <li><a href="book?action=showBooks&pageNum=${requestScope.bookPageData.pageNum - 1}&title=${requestScope.title}" aria-label="Previous" class="pag-num"><span aria-hidden="true">&laquo;</span></a></li>
            </c:if>
            <%-- 设置页码显示范围 --%>
            <c:choose>
                <%-- 情况 1：总页码小于 5，显示范围为 1 ~ 总页码 --%>
                <c:when test="${requestScope.bookPageData.pageTotal <= 5}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${requestScope.bookPageData.pageTotal}"/>
                </c:when>
                <%-- 情况 2：总页码数大于 5 --%>
                <c:when test="${requestScope.bookPageData.pageTotal > 5}">
                    <c:choose>
                        <%-- 子情况 2.1：当前页码为前 3 页，则页码显示范围为 1-5 页 --%>
                        <c:when test="${requestScope.bookPageData.pageNum <= 3}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="5"/>
                        </c:when>
                        <%-- 子情况 2.2：当前页码为末 3 页，则页码显示范围为末 5 页 --%>
                        <c:when test="${requestScope.bookPageData.pageNum >= requestScope.bookPageData.pageTotal - 2}">
                            <c:set var="begin" value="${requestScope.bookPageData.pageTotal - 4}"/>
                            <c:set var="end" value="${requestScope.bookPageData.pageTotal}"/>
                        </c:when>
                        <%-- 其余情况：页码显示范围为 pageTotal-2 到 pageTotal+2 --%>
                        <c:otherwise>
                            <c:set var="begin" value="${requestScope.bookPageData.pageNum - 2}"/>
                            <c:set var="end" value="${requestScope.bookPageData.pageNum + 2}"/>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <%-- 逐个输出页码 --%>
            <c:forEach begin="${begin}" end="${end}" var="i">
                <%-- 设置当前页码不可跳转并显示红色 --%>
                <c:if test="${i == requestScope.bookPageData.pageNum}">
                    <li><a class="pag-num" style="color: red">${i}</a></li>
                </c:if>
                <c:if test="${i != requestScope.bookPageData.pageNum}">
                    <li><a href="book?action=showBooks&pageNum=${i}&title=${requestScope.title}" class="pag-num">${i}</a></li>
                </c:if>
            </c:forEach>
            <%-- 显示下一页和尾页 --%>
            <c:if test="${requestScope.bookPageData.pageNum < requestScope.bookPageData.pageTotal}">
                <li><a href="book?action=showBooks&pageNum=${requestScope.bookPageData.pageNum + 1}&title=${requestScope.title}" aria-label="Next" class="pag-num"><span aria-hidden="true">&raquo;</span></a></li>
                <li><a href="book?action=showBooks&pageNum=${requestScope.bookPageData.pageTotal}&title=${requestScope.title}" class="pag-num pag-fl">尾页</a></li>
            </c:if>
            <div style="clear:both"></div>
        </ul>
    </nav>
</div>
<div class="bottom-content">
    <div><a>免责声明</a><span class="separator">|</span><a>关于我们</a><span class="separator">|</span><a>联系我们</a><span class="separator">|</span><a>友情链接</a></div>
    <div>Copyright © 2022, <a href="picture?action=showPixabay">Snake Nest.</a> All rights reserved.</div>
</div>
</body>
</html>