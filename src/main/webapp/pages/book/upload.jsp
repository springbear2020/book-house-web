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
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<c:if test="${ not empty requestScope.uploadMsg}">
    <div>${requestScope.uploadMsg}</div>
</c:if>
<%-- 图书文件上传表单 // TODO 调整此页面样式 --%>
<form action="bookServlet?action=uploadBook" method="post" enctype="multipart/form-data">
    <input type="hidden" name="uploadUsername" value="${sessionScope.user.username}">
    <hr/>
    <label>图书文件：<input type="file" name="book" accept="application/pdf"></label><br/>
    <hr/>
    <label>图书封面：<input type="file" name="bookCover" accept="image/jpeg,image/png"></label><br/>
    <hr/>
    <label>书&nbsp;名：<input type="text" name="title"/></label><br/>
    <hr/>
    <label>作&nbsp;者：<input type="text" name="author"/></label><br/>
    <hr/>
    <label>关键词：<input type="text" name="keywords"></label><br/>
    <hr/>
    <label><input type="submit" value="立即上传"></label>
</form>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
