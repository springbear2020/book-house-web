<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/22
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>图书上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/upload.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/upload.js"></script>

    <c:if test="${not empty requestScope.userUploadMsg}">
        <script type="text/javascript">alert("${requestScope.userUploadMsg}")</script>
        <% request.removeAttribute("userUploadMsg");%>
    </c:if>
</head>
<body>
<%-- // TODO 后端觉得前端应该将 footer, herder, title jsp 页面的样式单独封装，免得每次都要新写 --%>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <h2 class="up-title">图书上传</h2>
        <%-- 用户上传图书表单 --%>
        <form action="bookServlet?action=userUploadBook" method="post" enctype="multipart/form-data">
            <input type="hidden" name="username" value="${sessionScope.user.username}">
            <div class="bookFile upload-label"><label class="bookFile-true"><span>上传图书</span>
                <input type="file" name="book" accept="application/pdf" class="chooseFile"
                       style="display:block;opacity: 0"></label>
                <div class="fileInf"></div>
            </div>
            <div class="bookCover upload-label">
                <div class="bookCover-left">
                    <label class="chooseImg-true">
                        <div>上传封面</div>
                        <input type="file" name="cover" accept="image/jpeg,image/png" class="chooseImg"
                               style="display:block;opacity: 0">
                    </label>
                </div>
                <div class="img-border">
                    <div>封&nbsp;面</div>
                    <img class="bookCover-img" alt="封面加载失败">
                </div>
            </div>
            <label><input type="submit" value="立即上传" class="upload-btn"></label>
        </form>
    </div>
</div>
</body>
<%@include file="/pages/common/footer.jsp" %>
</html>