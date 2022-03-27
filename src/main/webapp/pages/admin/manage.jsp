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

    <script type="text/javascript">
        $(function () {
            $("#autoFill").click(function () {
                let $userIdText = $(".td-userId").val()
                alert($userIdText)
                // $(".form-userId").text();
                // $(".form-username").text($(".td-username"));
            });
        });
    </script>
</head>
<body>
<div class="title">Book House</div>
<div class="middle">
    <div class="frame-left">
        <a href="adminServlet?action=obtainBooks"><h2 class="right-up-title">Process Book</h2></a>
        <table border="1">
            <tr>
                <td>id</td>
                <td>user</td>
                <td>username</td>
                <td>book</td>
                <td>cover</td>
                <td>fill</td>
                <td>delete</td>
            </tr>
            <c:forEach items="${requestScope.waitProcessBookList}" var="upload">
                <tr>
                    <td>${upload.id}</td>
                    <td class="td-userId">${upload.userId}</td>
                    <td class="td-username">${upload.username}</td>
                    <td><a href="transferServlet?action=downloadFileByPath&path=${upload.bookPath}">get</a></td>
                    <td><a href="transferServlet?action=downloadFileByPath&path=${upload.coverPath}">get</a></td>
                    <td>
                        <button id="autoFill">fill</button>
                    </td>
                    <td>
                        <a href="adminServlet?action=deleteBookAndCover&uploadId=${upload.id}&bookPath=${upload.bookPath}&coverPath=${upload.coverPath}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="middle-container">
        <h2 class="up-title">Upload Book</h2>
        <a href="adminServlet?action=showPixabayRandomly" target="_self" class="toBack"><img
                src="static/img/icon_back.png" alt=""></a>
        <%-- Book file upload form --%>
        <form action="transferServlet?action=adminUploadBook" method="post" enctype="multipart/form-data">
            <label class="upload-label"><input placeholder="title" type="text" name="title" class="up-input"></label>
            <label class="upload-label"><input placeholder="author" type="text" name="author" class="up-input"></label>
            <label class="upload-label"><input placeholder="translator" type="text" name="translator" class="up-input"></label>
            <label class="upload-label"><input placeholder="keywords" type="text" name="keywords"
                                               class="up-input"></label>
            <label class="upload-label"><input placeholder="comments" type="text" name="comment"
                                               class="up-input"></label>
            <label class="upload-label"><input placeholder="username" type="text" name="username"
                                               class="up-input form-username"></label>
            <div class="bookFile upload-label"><label class="bookFile-true"><span>choose book</span>
                <input type="file" name="book" accept="application/pdf" class="chooseFile"
                       style="display:block;opacity: 0"></label>
                <div class="fileInf"></div>
            </div>
            <div class="bookCover upload-label">
                <div class="bookCover-left">
                    <label class="chooseImg-true">
                        <div>choose cover</div>
                        <input type="file" name="cover" accept="image/jpeg,image/png" class="chooseImg"
                               style="display:block;opacity: 0"></label>
                </div>
                <div class="img-border">
                    <div>cover</div>
                    <img class="bookCover-img" alt="" src="">
                </div>
            </div>
            <label><input type="submit" value="Upload" class="upload-btn"></label>
        </form>
    </div>

    <div class="frame-right">
        <h2 class="right-up-title">Issue Points</h2>
        <form>
            <input type="hidden" name="uploadUsername" value="${sessionScope.user.username}">
            <label class="upload-label"><input placeholder="user id" type="text" name="userId" disabled="disabled" class="up-input form-userId"></label>
            <label class="upload-label"><input placeholder="points" type="text" name="points" class="up-input" disabled="disabled" value="10"></label>
            <label class="upload-label"><input type="submit" class="up-input" value="submit"></label>
        </form>
    </div>
</div>
</body>
</html>

