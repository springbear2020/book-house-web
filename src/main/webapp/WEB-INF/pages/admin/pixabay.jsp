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
    <link rel="stylesheet" type="text/css" href="static/css/pixabay.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/pixabay.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<div class="pixabayManage"><img class="bk-img" alt="" src="${requestScope.pixabay.url}"/>
</div>
<main class="img-preview-main">
    <div class="users-input">
        <div class="title"><a href="index.jsp">Book House</a></div>
            <form method="post" action="admin" class="users-form">
                <input type="hidden" name="action" value="adminLogin">
                <label><input name="username" type="text" placeholder="username"></label>
                <label><input name="password" type="password" placeholder="password"></label>
                <label><input type="submit" value="login" class="btn"></label>
            </form>
    </div>
</main>
<table class="ad-table">
    <tr>
        <th>id</th>
        <th>views</th>
        <th>downloads</th>
        <th>condition</th>
        <th>tags</th>
        <th colspan="4"><a href="picture?action=deletePixabay&type=all">manage</a></th>
    </tr>
    <tr>
        <td>${requestScope.pixabay.id}</td>
        <td>${requestScope.pixabay.views}</td>
        <td>${requestScope.pixabay.downloads}</td>
        <td>${requestScope.pixabay.condition}</td>
        <td>${requestScope.pixabay.tags}</td>
        <td><a href="${requestScope.pixabay.url}" target="_blank">url</a></td>
        <td><a href="picture?action=deletePixabay&type=one&id=${requestScope.pixabay.id}">delete</a></td>
        <td><a href="picture?action=showPixabay" >next</a></td>
    </tr>
</table>
</body>
</html>
