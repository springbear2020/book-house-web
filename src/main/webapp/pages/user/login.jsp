<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/loginLog.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/loginLog.js"></script>

    <%-- 用户登录提示信息 --%>
    <c:if test="${ not empty sessionScope.loginMsg}">
        <div class="alert">${sessionScope.loginMsg}</div>
        <% session.removeAttribute("loginMsg");%>
    </c:if>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="frame-loginLog">
        <div class="loginLog-title">欢&nbsp;迎&nbsp;登&nbsp;录</div>
        <a href="index.jsp" class="backArrow"><img src="static/img/icon_back.png" alt="图片加载失败"></a>
        <%--  登录表单 --%>
        <form class="loginLog-box" action="userServlet" method="post">
            <input type="hidden" name="action" value="loginLog">
            <div class="loginLog-input">
                <label>
                    <input type="text" name="usernameOrEmail" placeholder="请输入用户名或邮箱" class="loginLog-username loginLog-text">
                </label>
            </div>
            <div class="loginLog-input">
                <label>
                    <input type="password" name="password" placeholder="请输入密码" class="loginLog-password loginLog-text">
                    <img class="pas-eye" src="static/img/eye.png" alt="图片加载失败">
                </label>
            </div>
            <div class="loginLog-button">
                <button type="submit" class="loginLog-btn" id="loginBtn">登&nbsp;录</button>
            </div>
            <div class="loginLog-littleText">
                <div>
                    <a class="loginLog-re" href="pages/user/pwdFind.jsp" target="_self">忘记密码?</a>
                    <span class="separator loginLog-sep">|</span>
                    <a class="loginLog-re" href="pages/user/register.jsp" target="_self">没有账号?</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>