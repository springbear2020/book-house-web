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
    <title>${requestScope.title}</title>
</head>
<body>
<%-- 用户图书下载记录 --%>
<c:if test="${not empty requestScope.downloadList}">
    <table>
        <tr>
            <th>下载时间</th>
            <th>书名</th>
        </tr>

        <c:forEach items="${requestScope.downloadList}" var="download">
            <tr>
                <td>${download.downloadTime}</td>
                <td>${download.title}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%-- 用户图书上传记录 --%>
<c:if test="${ not empty requestScope.uploadList}">
    <table>
        <tr>
            <th>上传时间</th>
            <th>书名</th>
        </tr>
        <c:forEach items="${requestScope.uploadList}" var="upload">
            <tr>
                <td>${upload.uploadTime}</td>
                <td>${upload.title}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
