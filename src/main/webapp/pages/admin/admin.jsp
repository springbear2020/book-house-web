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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/admin.js"></script>
</head>
<body>
<div class="pixabayManage"><img class="bk-img" alt="GET PICTURE FROM PIXABAY FAILED" src="${requestScope.pixabay.url}"/>
</div>
<main class="img-preview-main">
    <div class="users-input">
        <div class="title"><a href="index.jsp">Book House</a></div>
        <%-- Admin form --%>
        <c:if test="${ empty sessionScope.admin}">
            <form method="post" action="admin">
                <input type="hidden" name="action" value="login">
                <label><input name="username" type="text" placeholder="username"></label>
                <label><input name="password" type="password" placeholder="password"></label>
                <label><input type="submit" value="loginLog" class="btn"></label>
            </form>
        </c:if>
    </div>
    <%--    <c:if test="${not empty sessionScope.admin}">--%>
    <div class="img-a">
        <a href="admin?action=logout" class="logout-a"><img alt="" src="static/img/logout_admin.png"></a>
        <a href="pages/admin/manage.jsp" class="upload-a" target="_blank"><img alt="" src="static/img/upload_admin.png"></a>
    </div>
    <%--    </c:if>--%>
    <div class="left"><a href="admin?action=showPixabay"><img src="static/img/arrow_left.png" alt=""></a>
    </div>
    <div class="right"><a href="admin?action=showPixabay"><img src="static/img/arrow_right.png"
                                                                              alt=""></a></div>
</main>
<table class="ad-table">
    <tr>
        <th>id</th>
        <th>views</th>
        <th>likes</th>
        <th>downloads</th>
        <th>collections</th>
        <th>comments</th>
        <th>condition</th>
        <th>tags</th>
        <th>time</th>
        <th colspan="3">manage</th>
    </tr>
    <tr>
        <td>${requestScope.pixabay.id}</td>
        <td>${requestScope.pixabay.views}</td>
        <td>${requestScope.pixabay.likes}</td>
        <td>${requestScope.pixabay.downloads}</td>
        <td>${requestScope.pixabay.collections}</td>
        <td>${requestScope.pixabay.comments}</td>
        <td>${requestScope.pixabay.condition}</td>
        <td>${requestScope.pixabay.tags}</td>
        <td>${requestScope.pixabay.addTime}</td>
        <td><a href="${requestScope.pixabay.url}" target="_blank">link</a></td>
        <td><a href="pages/admin/background.jsp" target="_blank">upload</a></td>
        <td><a href="admin?action=deletePixabay&id=${requestScope.pixabay.id}">delete</a></td>
    </tr>
</table>
</body>
</html>
