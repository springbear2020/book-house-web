<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome! admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
</head>
<body>
<img class="bk-img" src="https://pixabay.com/get/g3bfa979e5a11fbda533f2cbe836b81d9481381a60bcf35c18607fee78a63d34dd48cc1a01c48cccb43740c82026b4647b82a927e6909432e8c99da6c471aae71d20ca9672f3666461b9cf0f0e5677031_1920.jpg">
<%@include file="/pages/common/title.jsp"%>
<!-- 中部 -->
<main class="img-preview-main">
<%--    <div>--%>
        <!-- 用户输入 -->
        <div class="users-input">
            <form>
                <label><input name="username" type="text" placeholder="admin username" ></label>
                <label><input name="password" type="text" placeholder="admin password" ></label>
                <label><input type="submit" value="login" class="btn"></label>
            </form>
        </div>
    <div class="left"><a href="#"><img src="static/img/left_arrow.png"></a></div>
    <div class="right"><a href="#"><img src="static/img/right_arrow.png"></a></div>
        <!-- 色图区域 -->
<%--        <div class="img-preview">--%>
            <!-- 左翻页 -->
<%--            <div class="page-left"><a href="#"><img src="static/img/icon_left.png"></a></div>--%>
<%--            <!-- 右翻页 -->--%>
<%--            <div class="page-right"><a href="#"><img src="static/img/icon_right.png"></a></div>--%>
            <!-- 色图 -->
<%--            <div class="page-img">--%>
<%--                <img src="https://pixabay.com/get/g44329b962fab75359ad337c123b5090dd875e84daa59ad3aae3b918a1cf59a957f9f2af60ac45ad6a3884683572049e14b72c341b6863fa44878e850d7df9ea2_1920.jpg">--%>
<%--&lt;%&ndash;                <img src="static/img/Cirno.jpg">&ndash;%&gt;--%>
<%--            </div>--%>
<%--        </div>--%>
        <!-- 底部导航 -->
<%--        <div  class="img-preview-points">--%>
<%--                <a href="javacript:;"></a>--%>
<%--                <a href="javacript:;"></a>--%>
<%--                <a href="javacript:;"></a>--%>
<%--                <a href="javacript:;"></a>--%>
<%--                <a href="javacript:;"></a>--%>
<%--        </div>--%>
<%--    </div>--%>
</main>
</body>
</html>
