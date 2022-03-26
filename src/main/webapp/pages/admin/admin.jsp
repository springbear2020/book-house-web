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
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
</head>
<body>
<img class="bk-img" alt="" src="https://pixabay.com/get/g3bfa979e5a11fbda533f2cbe836b81d9481381a60bcf35c18607fee78a63d34dd48cc1a01c48cccb43740c82026b4647b82a927e6909432e8c99da6c471aae71d20ca9672f3666461b9cf0f0e5677031_1920.jpg">
<%@include file="/pages/common/title.jsp"%>
<main class="img-preview-main">
<%--    <div>--%>
        <!-- 用户输入 -->
        <div class="users-input">
            <form>
                <label><input name="username" type="text" placeholder="username" ></label>
                <label><input name="password" type="text" placeholder="password" ></label>
                <label><input type="submit" value="login" class="btn"></label>
            </form>
        </div>
    <div class="left"><a href="#"><img src="static/img/left_arrow.png" alt=""></a></div>
    <div class="right"><a href="#"><img src="static/img/right_arrow.png" alt=""></a></div>
</main>
</body>
</html>
