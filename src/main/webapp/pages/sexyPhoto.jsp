<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>给我涩涩！</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/sexyPhoto.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
<%--    <script type="text/javascript" src="static/script/record.js"></script>--%>
</head>
<body>
<%@include file="/pages/common/header.jsp"%>
<!-- 中部 -->
<main class="img-preview-main">
    <div>
        <!-- 用户输入 -->
        <div class="users-input">
            <form>
                <label><input name="username" type="text" placeholder="当然是用户名了" value="古明地恋"></label>
                <label><input name="password" type="text" placeholder="当然是密码了" value="怎么可以看人家的密码"></label>
                <label><button>你真的需要按钮？</button></label>
            </form>
        </div>
        <!-- 色图区域 -->
        <div class="img-preview">
            <!-- 左翻页 -->
            <div class="page-left"><a href="#"><img src="static/img/icon_left.png"></a></div>
            <!-- 右翻页 -->
            <div class="page-right"><a href="#"><img src="static/img/icon_right.png"></a></div>
            <!-- 色图 -->
            <div class="page-img">
                <img src="https://i0.hdslb.com/bfs/article/381552787bdd10f5fcc83a11114817758a060937.jpg">
<%--                <img src="static/img/Cirno.jpg">--%>
            </div>
        </div>
        <!-- 底部导航 -->
        <div  class="img-preview-points">
                <a href="javacript:;"></a>
                <a href="javacript:;"></a>
                <a href="javacript:;"></a>
                <a href="javacript:;"></a>
                <a href="javacript:;"></a>
        </div>
    </div>
</main>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
