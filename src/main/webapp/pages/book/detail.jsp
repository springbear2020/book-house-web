<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/22
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>图书详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/detail.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
<%--    <script type="text/javascript" src="static/script/login.js"></script>--%>
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<div class="middle">
    <div class="middle-frame">
        <div class="book-inf">
            <div class="inf-left">
                <img src="static/img/Rushia.jpg" class="book_img">
            </div>
            <ul class="inf-right">
                <li><div>书名</div><p>露西娅</p></li>
                <li><div>作者</div><p>刘元日天</p></li>
                <li><div>关键词</div><p>色色</p></li>
                <li><div>下载量</div><p>51400000</p></li>
                <li><div>收藏量</div><p>514514</p></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
