<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>欢迎登录</title>

    <%@include file="/pages/common/header.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/user.css">
</head>
<body>
<div class="top-content">
    <ul class="top-left">
        <li class="top-left-title">Welcome&nbsp;to&nbsp;Book&nbsp;House</li>
    </ul>
</div>
<div class="middle">
    <div class="middle-container">

        <%--        <div class="middle-images">--%>
        <%--            <img alt="涩图已失效" src="https://wx2.sinaimg.cn/mw2000/003tUy6ply1guoegkvuymj60jg0jgqa002.jpg"--%>
        <%--                 class="middle-pic">--%>
        <%--        </div>--%>

        <div class="frame-login">
            <div class="login-title">欢&nbsp&nbsp迎&nbsp&nbsp登&nbsp&nbsp录</div>
            <form class="login-box" action="userServlet" method="post">
                <input type="hidden" name="action" value="login">
                <div class="login-input"><label>
                    <input type="text" name="username" placeholder="&nbsp&nbsp请输入用户名"
                           class="login-username login-text">
                </label>
                </div>
                <div class="login-input"><label>
                    <input type="text" name="password" placeholder="&nbsp&nbsp请输入密码"
                           class="login-password login-text">
                </label></div>
                <div class="login-littleText">
                    <div class="login-error">账号或密码错误</div>
                    <div class="login-register"><a class="login-re" href="pages/user/register.jsp"
                                                   target="_self">忘记密码?</a> | <a
                            class="login-re" href="pages/user/register.jsp" target="_self">没有账号?</a></div>
                </div>
                <div class="login-button">
                    <button type="submit" class="login-btn">登录</button>
                </div>
                <!-- //TODO 给登录按钮绑定单击事件，使用正则表达式是否合法，发起请求验证用户名密码正确性 -->
                <!-- 留点空位 说不定能塞点啥 -->
            </form>
        </div>
    </div>
</div>
<div class="bottom-content"></div>
</body>
</html>