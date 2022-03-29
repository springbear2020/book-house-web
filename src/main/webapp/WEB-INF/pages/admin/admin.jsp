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
    <title>Admin</title>
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
<div class="pixabayManage"><img class="bk-img" alt="" src="${requestScope.background.path}"/>
</div>
<main class="img-preview-main">
    <div class="img-a">
        <%--        TODO CSS 样式呐--%>
        <a href="user?action=pageRedirect&type=background" class="a-bk">background</a>
        <a href="user?action=pageRedirect&type=book" class="a-book" target="_self">book</a>
        <a href="admin?action=adminLogout" class="logout-a">logout</a>
    </div>
</main>
<span class="title">Pixabay</span>
<%--<div class="pic-word">${requestScope.background.sentence}</div>--%>
<table class="ad-table">
    <tr>
        <th>id</th>
        <th>user</th>
        <th>url</th>
        <th>next</th>
    </tr>
    <tr>
        <td>${requestScope.background.id}</td>
        <td>${requestScope.background.uploadUser}</td>
        <td><a href="${requestScope.background.path}" target="_blank">url</a></td>
        <td><a href="picture?action=showBackground">next</a></td>
    </tr>
</table>
</body>
</html>