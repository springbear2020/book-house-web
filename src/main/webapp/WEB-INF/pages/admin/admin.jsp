<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <%@include file="/WEB-INF/pages/common/base.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/admin.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<div class="pixabayManage"><img class="bk-img" alt="" src=""/>
</div>
<main class="img-preview-main">
    <div class="img-a">
        <a href="user?action=pageRedirect&type=manage" class="upload-a" target="_blank">process book</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="admin?action=adminLogout" class="logout-a">logout</a>
    </div>
</main>
<table class="ad-table">
</table>
</body>
</html>