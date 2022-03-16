<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <%@include file="/pages/common/header.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/user.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/register.js"></script>
</head>

<body>
<div class="top-content">
    <ul class="top-left">
        <li class="top-left-title">Book&nbsp;House</li>
    </ul>
</div>
<div class="middle">
    <div class="middle-container">

        <%--   // TODO 背景图片    --%>

        <div class="frame-login">
            <div class="login-title">欢&nbsp&nbsp迎&nbsp&nbsp注&nbsp&nbsp册</div>
            <form class="login-box" action="userServlet" method="post">
                <input type="hidden" name="action" value="register">

                <div class="login-input"><label>
                    <input type="text" name="username" placeholder="&nbsp;请输入用户名"
                           class="login-username login-text">
                    <div class="little-tips">*可使用数字、字母、下划线，但要以字母开头</div>
                </label></div>

                <!-- // TODO 此处应添加一只小眼睛以提供密码隐藏与显示功能-->
                <div class="login-input"><label>
                    <input type="text" name="password" placeholder="&nbsp;请输入密码"
                           class="login-password login-text">
                    <div class="little-tips">*由长度为5到15位的字母、数字或下划线组成</div>
                </label></div>

                <div class="login-input"><label>
                    <input type="email" name="email" placeholder="&nbsp;邮箱地址" class="login-password login-text">
                    <div class="little-tips">*请输入正确的邮箱地址</div>
                </label></div>

                <div class="login-input"><label>
                    <input type="text" name="emailVerifyCode" placeholder="&nbsp;邮箱验证码" class="vercode">
                    <input type="button" id="emailVerifyCode" value="获取验证码" class="email-btn">
                    <div class="little-tips">${requestScope.emailErrorMsg}</div>
                </label>
                </div>

                <div class="login-input"><label>
                    <input type="text" name="imgVerifyCode" placeholder="&nbsp;图片验证码" class="vercode img-text">
                    <img id="imgVerifyCode" alt="验证码加载失败，请稍后重试" src="imgVerifyCode.jpg"/>
                    <div class="little-tips">${requestScope.imgErrorMsg}</div>
                </label>
                </div>

                <div class="login-button">
                    <button type="submit" class="login-btn">立即注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom-content"></div>
</body>
</html>