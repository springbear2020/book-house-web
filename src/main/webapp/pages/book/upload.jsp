<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/22
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>图书上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
</head>
<body>
<%-- // TODO 鄙人觉得前端应该将 footer, herder, title jsp 页面的样式单独封装，免得每次都要新写 --%>
<%@include file="/pages/common/header.jsp" %>
<form action="bookServlet?action=userUploadBook" method="post" enctype="multipart/form-data">
    <input type="hidden" name="username" value="${sessionScope.user.username}">
    图书文件：<input type="file" name="book" accept="application/pdf">
    <hr/>
    封面文件：<input input type="file" name="cover" accept="image/jpeg,image/png">
    <hr/>
    <input type="submit" value="立即上传">
</form>
</body>
<%@include file="/pages/common/footer.jsp" %>
</html>