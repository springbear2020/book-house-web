<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/20
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="top-content">
    <div class="top-left">
        <span class="top-left-title">Book House</span>
    </div>
    <ul class="top-center">
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="index.jsp" class="example">首页</a></li>
            <li><a href="pages/book/upload.jsp" class="example">上传</a></li>
            <li><a href="#" class="example">收藏夹</a></li>
        </c:if>
    </ul>
    <ul class="top-right">
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="#" class="example">通知</a></li>
            <li><a href="#" class="example">个人</a></li>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <li><a href="pages/user/login.jsp" class="example">登录</a></li>
            <li><a href="pages/user/register.jsp" class="example">注册</a></li>
        </c:if>
    </ul>
</div>
