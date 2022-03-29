<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/29
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Background</title>
    <%@include file="/WEB-INF/pages/common/base.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<%--    // TODO 样式呐--%>
<form action="transfer?action=uploadBackground" enctype="multipart/form-data" method="post">
    <input type="hidden" name="uploadUser" value="${sessionScope.admin.username}">
    <label><input type="text" name="sentence" placeholder="some words hit the heart"/></label><hr/>
    <input type="file" name="background"/><hr/>
    <input type="submit" value="submit"/><hr/>
</form>
</body>
</html>
