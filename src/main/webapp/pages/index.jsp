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
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="search">
        <div class="search-container">
            <%-- 搜索框表单 --%>
            <form class="search-form" method="post" action="#">
                <label><input class="search-text" placeholder="请输入书名"></label>
                <button type="submit" class="search-btn">搜索</button>
                <ul class="search-list">
                    <li class="search-li">...</li>
                    <li class="search-li">...</li>
                    <li class="search-li">...</li>
                </ul>
            </form>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${requestScope.books}" var="book">
            <div class="one-book">
                <div class="thumbnail">
                    <img class="img-books" src="${book.bookCoverPath}" alt="封面加载失败">
                    <div class="caption">
                        <div><span>${book.title}</span></div>
                        <div><span>${book.author}</span></div>
                        <div><span>${book.keywords}</span></div>
                        <div><span>下载量：${book.downloads}</span></div>
                        <div><span>收藏数：${book.collections}</span></div>
                        <a href="">下载</a>
                        <a href="">收藏</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <nav aria-label="Page navigation" class="pag-chs">
        <ul class="pagination">
            <li><a href="#" class="pag-num pag-fl">首页</a></li>
            <li><a href="#" aria-label="Previous" class="pag-num"><span aria-hidden="true">&laquo;</span></a></li>
            <li><a href="#" class="pag-num">1</a></li>
            <li><a href="#" class="pag-num">2</a></li>
            <li><a href="#" class="pag-num">3</a></li>
            <li><a href="#" class="pag-num">4</a></li>
            <li><a href="#" class="pag-num">5</a></li>
            <li><a href="#" aria-label="Next" class="pag-num"><span aria-hidden="true">&raquo;</span></a></li>
            <li><a href="#" class="pag-num pag-fl">尾页</a></li>
        </ul>
    </nav>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
