<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/23
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/record.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/record.js"></script>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <ul class="table-choose">
            <a href="recordServlet?action=showUpload&userId=${sessionScope.user.id}"
               class="choose-upload choose-li">上传</a>
            <a href="recordServlet?action=showDownload&userId=${sessionScope.user.id}"
               class="choose-download choose-li">下载</a>
            <a href="recordServlet?action=showLoginLog&userId=${sessionScope.user.id}"
               class="choose-log choose-li">登录</a>
        </ul>
        <c:if test="${not empty requestScope.recordList}">
            <table class="pure-table">
                <thead>
                <tr>
                    <th>类型</th>
                    <th>积分</th>
                    <th>时间</th>
                    <th>书名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.recordList}" var="record">
                    <tr class="pure-table-odd">
                        <td>${record.operation}</td>
                        <td>${record.scoreChange}</td>
                        <td>${record.time}</td>
                        <td class="tb-title">${record.title}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${not empty requestScope.loginList}">
            <table class="pure-table">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>IP</th>
                    <th>时间</th>
                    <th>地点</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.loginList}" var="login">
                    <tr class="pure-table-odd">
                        <td>${login.username}</td>
                        <td>${login.ip}</td>
                        <td>${login.time}</td>
                        <td class="tb-title">${login.location}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
