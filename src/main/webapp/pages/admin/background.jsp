<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/28
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Background</title>
    <%@include file="/pages/common/base.jsp" %>
</head>
<body>
<form action="transferServlet?action=adminUploadPixabay" method="post" enctype="multipart/form-data">
    <input type="file" name="background">
    <input type="submit" value="upload">
</form>
</body>
</html>
