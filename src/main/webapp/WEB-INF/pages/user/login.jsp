<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/WEB-INF/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/login.js"></script>

    <%-- 用户登录提示信息 --%>
    <c:if test="${ not empty sessionScope.loginMsg}">
        <div class="alert">${sessionScope.loginMsg}</div>
        <% session.removeAttribute("loginMsg");%>
    </c:if>
    <%-- 提示信息 --%>
    <%@include file="/WEB-INF/pages/common/notice.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/pages/common/header.jsp" %>
<div class="middle">
    <div class="frame-login">
        <div class="login-title">欢&nbsp;迎&nbsp;登&nbsp;录</div>
        <a href="index.jsp" class="backArrow"><img src="static/img/icon_back.png" alt=""></a>
        <%--  登录表单 --%>
        <form class="login-box" action="user" method="post">
            <input type="hidden" name="action" value="login">
            <div class="login-input"><label><input type="text" value="admin" name="usernameOrEmail" placeholder="请输入用户名或邮箱" class="login-username login-text"></label></div>
            <div class="login-input"><label><input type="password" value="admin" name="password" placeholder="请输入密码" class="login-password login-text"><img class="pas-eye" src="static/img/eye.png" alt=""></label></div>
            <div class="login-button"><button type="submit" class="login-btn" id="loginBtn">登&nbsp;录</button></div>
            <div class="login-littleText"><div><a class="login-re" href="user?action=pageRedirect&type=pwdFind" target="_self">忘记密码?</a><span class="separator login-sep">|</span><a class="login-re" href="user?action=pageRedirect&type=register" target="_self">没有账号?</a></div></div>
        </form>
    </div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
</html>