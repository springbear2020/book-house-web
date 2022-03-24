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
    <title>图书记录</title>
    <script type="text/javascript" src="static/script/tools.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
</head>
<body>
<%-- // TODO 前端，样式又不行了啦 --%>
<%@include file="/pages/common/header.jsp"%>
    <table>
        <tr>
            <th>操作类型</th>
            <th>积分变化</th>
            <th>操作时间</th>
            <th>书名</th>
        </tr>
        <c:forEach items="${requestScope.recordList}" var="record">
            <tr>
                <td>${record.operation}</td>
                <td>${record.scoreChange}</td>
                <td>${record.time}</td>
                <td>${record.title}</td>
            </tr>
        </c:forEach>
    </table>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
