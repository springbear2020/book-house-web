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
    <link rel="stylesheet" type="text/css" href="static/css/background.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/background.js"></script>

    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<img src="static/img/500.png" class="bk" alt="this is background">
<form action="transfer?action=uploadBackground" enctype="multipart/form-data" method="post" class="form">
    <input type="hidden" name="uploadUser" value="${sessionScope.admin.username}">
    <%--    如果文本域不行就直接注释掉 两个都写了样式--%>
<%--    <label><input type="text" name="sentence" placeholder="some words hit the heart" class="input-text"/></label>--%>
    <label><textarea placeholder="some words hit the heart" name="sentence" class="input-textarea"></textarea></label>
    <input type="file" name="background" id="img-choose"/>
    <label for="img-choose" class="img-true">submit pic</label>
    <input type="submit" value="submit" class="submit"/>
</form>
</body>
</html>
