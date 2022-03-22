<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/20
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book House</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/index.js"></script>
</head>
<body>
<div class="top-content">
    <div class="top-left">
        <span class="top-left-title">Book House</span>
    </div>
    <ul class="top-center">
        <%-- 用户登录后才显示首页、上传、收藏夹、通知、个人等入口 --%>
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="index.jsp" class="example">首页</a></li>
            <li><a href="pages/book/upload.jsp" class="example" target="_self">上传</a></li>
            <li><a href="#" class="example">收藏夹</a></li>
        </c:if>
    </ul>
    <c:if test="${ not empty sessionScope.user}">
        <ul class="top-self">
            <li><a href="#" class="top_bell"><img class="bell" src="static/img/icon_bell.png" alt="通知"></a></li>
            <script type="text/javascript">${requestScope.user.portraitPath}</script>
            <li><a href="#" class="head_img"><img src="${sessionScope.user.portraitPath}" alt="个人"></a></li>
            <ul class="self-frame">
                <a href="userServlet?action=logout">
                    <li>注销</li>
                </a>
            </ul>
        </ul>
    </c:if>
    <%-- 用户未登录才显示登录、注册入口 --%>
    <c:if test="${empty sessionScope.user}">
        <ul class="top-right">
            <li><a href="pages/user/login.jsp" class="example">登录</a></li>
            <li><a href="pages/user/register.jsp" class="example">注册</a></li>
        </ul>
    </c:if>
</div>
<div class="middle">
    <div class="search">
        <div class="search-container">
            <%-- 搜索框表单 --%>
            <form class="search-form" method="post" action="#">
                <label><input class="search-text" placeholder="请输入检索内容"></label>
                <button type="submit" class="search-btn">搜索</button>
                <ul class="search-list">
                    <div class="search-choose">
                        <li class="search-word">书名</li>
                        <li class="search-word">作者</li>
                        <li class="search-word">关键词</li>
                    </div>
                    <li class="search-li">搜出来的东西</li>
                    <li class="search-li">就像搜索引擎那样</li>
                    <li class="search-li">相信你可以的√</li>
                </ul>
            </form>
        </div>
    </div>

    <%-- 显示图书数据 --%>
    <div class="row">
        <c:forEach items="${requestScope.bookPageData.pageData}" var="book">
            <div class="one-book">
                <div class="thumbnail">
<%--                    // TODO 等待处理跳转到详情页信息显示 --%>
                    <a href="pages/book/detail.jsp"><img class="img-books" src="${book.coverPath}" alt="封面加载失败"></a>
                    <div class="caption">
                        <div><span>${book.id}</span></div>
                        <div><h5>《${book.title}》</h5></div>
                        <div><span>下载量:${book.downloads} 收藏量:${book.collections}</span></div>
                            <%-- // TODO 图书信息显示大改啊，等你啊，前端--%>
                        <a href="bookServlet?action=downloadBook&id=${book.id}">下载</a>
                        <a href="">收藏</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div style="clear:both"></div>
    </div>

    <%-- 设置分页条页码显示范围 --%>
    <nav aria-label="Page navigation" class="pag-chs">
        <ul class="pagination">
            <%-- 总页数大于 1 才显示首页和上一页 --%>
            <c:if test="${requestScope.bookPageData.pageTotal > 1 && requestScope.bookPageData.pageNum != 1}">
                <li><a href="bookServlet?action=listBooksByPageNum" class="pag-num pag-fl">首页</a></li>
                <li><a href="bookServlet?action=listBooksByPageNum&pageNum=${requestScope.bookPageData.pageNum - 1}"
                       aria-label="Previous" class="pag-num"><span aria-hidden="true">&laquo;</span></a></li>
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
                    <li><a href="bookServlet?action=listBooksByPageNum&pageNum=${i}" class="pag-num">${i}</a></li>
                </c:if>
            </c:forEach>

            <%-- 显示下一页和尾页 --%>
            <c:if test="${requestScope.bookPageData.pageNum < requestScope.bookPageData.pageTotal}">
                <li><a href="bookServlet?action=listBooksByPageNum&pageNum=${requestScope.bookPageData.pageNum + 1}"
                       aria-label="Next" class="pag-num"><span aria-hidden="true">&raquo;</span></a></li>
                <li><a href="bookServlet?action=listBooksByPageNum&pageNum=${requestScope.bookPageData.pageTotal}"
                       class="pag-num pag-fl">尾页</a></li>
            </c:if>
            <div style="clear:both"></div>
        </ul>
        <%--        <div style="clear:both"></div>--%>
    </nav>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
