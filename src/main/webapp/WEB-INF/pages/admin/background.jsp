<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/28
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta charset="utf-8">
    <title>Background</title>
    <%@include file="/WEB-INF/pages/common/base.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<form action="transfer?action=uploadPixabay" method="post" enctype="multipart/form-data">
    <input type="file" name="background">
    <input type="submit" value="upload">
</form>
</body>
</html>