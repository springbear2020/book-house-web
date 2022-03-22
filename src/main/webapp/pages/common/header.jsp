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
        <%-- 用户登录后才显示首页、上传、收藏夹、通知、个人等入口 --%>
        <c:if test="${ not empty sessionScope.user}">
            <li><a href="index.jsp" class="example">首页</a></li>
            <li><a href="pages/book/upload.jsp" class="example" target="_self">上传</a></li>
            <li><a href="#" class="example">收藏夹</a></li>
        </c:if>
    </ul>
    <c:if test="${ not empty sessionScope.user}">
        <ul class="top-self">
            <li><a href="#" class="top_bell"><img class="bell" src="static/img/icon_bell.png" alt="通知"></a></li>
            <script type="text/javascript">${requestScope.user.portraitPath}</script>
<%--            // TODO 人家想要一个圆头像啦，方方的，怪怪的，丑丑的 --%>
            <li><a href="#" class="head_img"><img src="${sessionScope.user.portraitPath}" alt="个人"></a></li>
            <ul class="self-frame">
                <a href="userServlet?action=logout">
                    <li>注销</li>
                </a>
            </ul>
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
