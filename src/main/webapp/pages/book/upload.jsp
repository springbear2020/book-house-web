<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/20
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/upload.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/upload.js"></script>
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<c:if test="${ not empty requestScope.uploadMsg}">
    <div>${requestScope.uploadMsg}</div>
</c:if>
<%-- 图书文件上传表单 --%>
<div class="middle">
    <div class="middle-container">
        <h2 class="up-title">上传图书</h2>
        <form action="bookServlet?action=uploadBook" method="post" enctype="multipart/form-data">
            <input type="hidden" name="uploadUsername" value="${sessionScope.user.username}">
            <label class="upload-label">
                <span>书&nbsp;名：</span>
                <input type="text" name="title" class="up-input">
            </label>
            <label class="upload-label">
                <span>作&nbsp;者：</span>
                <input type="text" name="author" class="up-input">
            </label>
            <label class="upload-label">
                <span>关键词：</span>
                <input type="text" name="keywords" class="up-input">
            </label>
            <label class="bookFile upload-label">
                <span>图书文件：</span>
                <input type="file" name="book" accept="application/pdf">
            </label>
            <div class="bookCover upload-label">
                <div class="bookCover-left">
                    <label class="chooseImg-true">
                        <div>上传封面</div>
                        <input type="file" name="bookCover" accept="image/jpeg,image/png" class="chooseImg" style="opacity: 0">
                    </label>
                </div>
                <img class="bookCover-img" alt="封面加载失败">
            </div>
            <label><input type="submit" value="立即上传" class="upload-btn"></label>
        </form>
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
