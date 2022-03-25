<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/23
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>个人信息</title>
    <%@include file="/pages/common/base.jsp" %>
    <script type="text/javascript" src="static/script/tools.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<img src="${requestScope.user.portraitPath}" alt=""/>
<form>
    用户名：<input type="text" value="${sessionScope.user.username}"><hr/>
    密  码：<input type="password" value="${sessionScope.user.password}"><hr/>
    邮  箱：<input type="text" value="${sessionScope.user.email}"><hr/>
    个人积分：<input type="text" disabled="disabled" value="${sessionScope.user.score}"><hr/>
    注册时间：<input type="text" disabled="disabled" value="${sessionScope.user.registerDate}"><hr/>
</form>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
