<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/login.js"></script>
</head>
<body>
<%@include file="/pages/common/header.jsp"%>
<div class="middle">
    <div class="middle-container">
        <div class="frame-login">
            <div class="login-title">欢&nbsp;迎&nbsp;登&nbsp;录</div>
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
                    <button type="submit" class="login-btn">登&nbsp录</button>
                </div>

                <div class="login-littleText">
                    <div class="login-register"><a class="login-re" href="pages/user/register.jsp"
                                                   target="_blank">忘记密码?</a> |
                        <a class="login-re" href="pages/user/register.jsp" target="_blank">没有账号?</a></div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>