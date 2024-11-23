<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/1
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 动态获取工程经服务器部署后的地址：http://ip:port/project/ --%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<base href="/book-house-web/">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>