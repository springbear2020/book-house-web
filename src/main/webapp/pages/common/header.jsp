<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/22
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="top-content">
    <div class="top-left">
        <span class="top-left-title">Book House</span>
    </div>
    <ul class="top-center">
        <li><a href="index.jsp" class="example">首页</a></li>
        <%-- 用户登录后显示上传、收藏、记录入口 --%>
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="pages/book/upload.jsp" class="example" target="_self">上传</a></li>
            <li><a href="record?action=showFavorites&userId=${sessionScope.user.id}" class="example">收藏</a></li>
            <li><a href="record?action=showLog&userId=${sessionScope.user.id}" class="example">记录</a></li>
        </c:if>
    </ul>
    <%-- 用户登录后显示积分通知、个人信息、退出登录入口 --%>
    <c:if test="${ not empty sessionScope.user}">
        <ul class="top-self">
            <li class="bell-fa"><a class="top_bell" title="积分通知"><img class="bell" src="static/img/icon_bell.png" alt=""></a>
                <div class="bell-frame">
                    <ul class="bell-ul">
                        <c:if test="${empty sessionScope.notifications}"><p>这里还什么都没有</p></c:if>
                        <c:forEach items="${sessionScope.notifications }" var="notice"><li>${notice}</li></c:forEach>
                    </ul>
                </div>
            </li>
            <li><a href="user?action=showPersonal" class="head_img" title="个人信息"><img src="${sessionScope.user.portraitPath}" alt=""></a></li>
            <li><a class="logout" href="user?action=logout" title="退出登录"><img src="static/img/logout.png" alt=""></a></li>
        </ul>
    </c:if>
    <%-- 用户未登录显示登录、注册入口 --%>
    <c:if test="${empty sessionScope.user}">
        <ul class="top-right">
            <li><a href="pages/user/login.jsp" class="example">登录</a></li>
            <li><a href="pages/user/register.jsp" class="example">注册</a></li>
        </ul>
    </c:if>
</div>
