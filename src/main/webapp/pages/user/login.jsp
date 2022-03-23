<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/login.js"></script>

    <c:if test="${ not empty requestScope.loginMsg}">
        <div class="alert">${requestScope.loginMsg}</div>
        <% request.removeAttribute("loginMsg");%>
    </c:if>
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<div class="middle">
    <div class="frame-login">
        <div class="login-title">欢&nbsp;迎&nbsp;登&nbsp;录</div>
        <a href="index.jsp" class="backArrow"><img src="static/img/icon_back.png" alt="图片加载失败"></a>
        <%--  登录表单 --%>
        <form class="login-box" action="userServlet" method="post">
            <input type="hidden" name="action" value="login">
            <div class="login-input"><label>
                <input type="text" name="username" placeholder="请输入用户名"
                       class="login-username login-text">
            </label></div>
            <div class="login-input"><label>
                <input type="password" name="password" placeholder="请输入密码"
                       class="login-password login-text">
                <img class="pas-eye" src="static/img/eye.png" alt="图片加载失败">
            </label></div>
            <div class="login-button">
                <button type="submit" class="login-btn">登&nbsp;录</button>
            </div>
            <div class="login-littleText">
                <div><a class="login-re" href="pages/user/pwdFind.jsp" target="_self">忘记密码?</a><span
                        class="separator login-sep">|</span><a
                        class="login-re" href="pages/user/register.jsp" target="_self">没有账号?</a></div>
                <div></div>
            </div>
        </form>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>