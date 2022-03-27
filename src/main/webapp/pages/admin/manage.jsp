<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/27
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/manage.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
</head>
<body>
<div class="title">Book House</div>
<div class="middle">
    <div class="middle-container">
        <h2 class="up-title">Upload Book</h2>
        <a href="adminServlet?action=showPixabayRandomly" target="_self" class="toBack"><img
                src="static/img/icon_back.png" alt=""></a>
        <%-- Book file upload form --%>
        <form action="transferServlet?action=adminUploadBook" method="post" enctype="multipart/form-data">
            <input type="hidden" name="uploadUsername" value="${sessionScope.user.username}">
            <label class="upload-label"><input placeholder="title" type="text" name="title" class="up-input"></label>
            <label class="upload-label"><input placeholder="author" type="text" name="author" class="up-input"></label>
            <label class="upload-label"><input  placeholder="translator" type="text" name="translator"
                                                                     class="up-input"></label>
            <label class="upload-label"><input placeholder="keywords" type="text" name="keywords" class="up-input"></label>
            <label class="upload-label"><input placeholder="comments" type="text" name="comment"
                                                                     class="up-input"></label>
            <div class="bookFile upload-label"><label class="bookFile-true"><span>Choose Book</span>
                <input type="file" name="book" accept="application/pdf" class="chooseFile"
                       style="display:block;opacity: 0"></label>
                <div class="fileInf"></div>
            </div>
            <div class="bookCover upload-label">
                <div class="bookCover-left">
                    <label class="chooseImg-true">
                        <div>Choose Cover</div>
                        <input type="file" name="cover" accept="image/jpeg,image/png" class="chooseImg"
                               style="display:block;opacity: 0">
                    </label>
                </div>
                <div class="img-border">
                    <div>Cover</div>
                    <img class="bookCover-img" alt="" src="">
                </div>
            </div>
            <label><input type="submit" value="Upload" class="upload-btn"></label>
        </form>
    </div>
</div>
</body>
</html>

