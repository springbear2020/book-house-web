<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
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
</head>
<body>
<a href="pages/user/login.jsp" class="pixabayManage"><img class="bk-img" alt="" src="${requestScope.pixabay.url}"/></a>
<main class="img-preview-main">

    <!-- 用户输入 -->
    <div class="users-input">

        <div class="title">Book House</div>
        <form>
            <label><input name="username" type="text" placeholder="username"></label>
            <label><input name="password" type="text" placeholder="password"></label>
            <label><input type="submit" value="login" class="btn"></label>
        </form>
    </div>
    <div class="left"><a href="adminServlet?action=showPixabayRandomly"><img src="static/img/left_arrow.png" alt=""></a>
    </div>
    <div class="right"><a href="adminServlet?action=showPixabayRandomly"><img src="static/img/right_arrow.png"
                                                                              alt=""></a></div>
</main>
<table border="1">
    <tr >
        <th>ID</th>
        <th>Views</th>
        <th>Likes</th>
        <th>Downloads</th>
        <th>Collections</th>
        <th>Comments</th>
        <th>Condition</th>
        <th>Tags</th>
        <th>Link</th>
        <th>AddTime</th>
        <th colspan="2">Manage</th>
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
        <td><a href="${requestScope.pixabay.url}">link</a></td>
        <td><a href="#">Favorite</a></td>
        <td><a href="#">Delete</a></td>
    </tr>
</table>
</body>
</html>
