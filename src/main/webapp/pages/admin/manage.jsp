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
    <%@include file="/pages/common/base.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/manage.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/manage.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/pages/common/notice.jsp" %>
</head>
<body>
<div class="title"><a href="index.jsp">Book House</a></div>
<div class="middle">
    <div class="middle-container">
        <a href="admin?action=obtainBook"><h2 class="right-up-title">Process Book</h2></a>
        <a href="pages/admin/admin.jsp"><div class="toBack"><img src="static/img/icon_back.png" alt=""></div></a>
        <table class="ma-table">
            <tr>
                <td>uid</td>
                <td>uname</td>
                <td colspan="2">download</td>
            </tr>
            <tr>
                <td class="td-userId">${requestScope.upload.userId}</td>
                <td class="td-username">${requestScope.upload.username}</td>
                <td><a href="transfer?action=downloadFile&path=${requestScope.upload.bookPath}">book</a></td>
                <td><a href="transfer?action=downloadFile&path=${requestScope.upload.coverPath}">cover</a></td>
            </tr>
        </table>
        <%-- Book file upload form --%>
        <form action="transfer?action=processBook" method="post" enctype="multipart/form-data">
            <input type="hidden" name="userId" value="${requestScope.upload.userId}">
            <input type="hidden" name="uploadUsername" value="${requestScope.upload.username}">
            <input type="hidden" name="uploadId" value="${requestScope.upload.id}">
            <input type="hidden" name="bookPath" value="${requestScope.upload.bookPath}">
            <input type="hidden" name="coverPath" value="${requestScope.upload.coverPath}">
            <label class="upload-label"><input placeholder="title" type="text" name="title" class="up-input"></label>
            <label class="upload-label"><input placeholder="author" type="text" name="author" class="up-input"></label>
            <label class="upload-label"><input placeholder="translator" type="text" name="translator" class="up-input"></label>
            <label class="upload-label"><input placeholder="keywords" type="text" name="keywords" class="up-input"></label>
            <label class="upload-label"><input placeholder="comments" type="text" name="comment" class="up-input"></label>
            <div class="bookFile upload-label"><label class="bookFile-true"><span>choose book</span>
                <input type="file" name="book" accept="application/pdf" class="chooseFile" style="display:block;opacity: 0"></label>
                <div class="fileInf">please choose book</div>
            </div>
            <div class="bookCover upload-label">
                <div class="bookCover-left">
                    <label class="chooseImg-true"><div>choose cover</div>
                        <input type="file" name="cover" accept="image/jpeg,image/png" class="chooseImg" style="display:block;opacity: 0">
                    </label>
                </div>
                <div class="img-border">
                    <div>cover</div>
                    <img class="bookCover-img" alt="" src="">
                </div>
            </div>
            <label><input type="submit" value="Upload" class="upload-btn"></label>
        </form>
    </div>
</div>
</body>
</html>

