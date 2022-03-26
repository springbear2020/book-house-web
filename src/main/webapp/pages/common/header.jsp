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
        <%-- 用户登录后才显示上传、收藏夹、通知、个人等入口 --%>
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="pages/book/upload.jsp" class="example" target="_self">上传</a></li>
            <li><a href="favoriteServlet?action=showFavorites&userId=${sessionScope.user.id}" class="example">收藏</a></li>
            <li><a href="pages/book/record.jsp" class="example">记录</a></li>
        </c:if>
    </ul>
    <c:if test="${ not empty sessionScope.user}">
        <ul class="top-self">
            <li><a href="" class="top_bell"><img class="bell" src="static/img/icon_bell.png" alt="Notifications"></a>
            </li>
            <li><a href="userServlet?action=showPersonal" class="head_img" title="个人详情"><img src="${sessionScope.user.portraitPath}"
                                                                            alt="Personal"></a></li>
            <li>
                <a class="logout" href="userServlet?action=logout" title="退出登录">
                    <img src="static/img/logout.png" alt="退出登录">
                </a>
            </li>

        </ul>
    </c:if>
    <%-- 用户未登录才显示登录、注册入口 --%>
    <c:if test="${empty sessionScope.user}">
        <ul class="top-right">
            <li><a href="pages/user/login.jsp" class="example">登录</a></li>
            <li><a href="pages/user/register.jsp" class="example">注册</a></li>
        </ul>
    </c:if>
</div>
