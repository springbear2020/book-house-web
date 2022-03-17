<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/register.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/register.js"></script>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <%--   // TODO 背景图片    --%>
        <div class="frame-register">
            <div class="register-title">欢&nbsp;迎&nbsp;注&nbsp;册</div>
            <form class="register-box" action="userServlet" method="post">
                <input type="hidden" name="action" value="register">

                <div class="register-input"><label>
                    <input type="text" name="username" placeholder="&nbsp;用户名" class="register-username register-text"
                           value="${ empty requestScope.user.username? "" : requestScope.user.username}">
                    <div class="little-tips tips-username">* 由字母、数字、下划线组成，长度为 1~15 且以字母开头</div>
                </label></div>

                <!-- // TODO 此处应添加一只小眼睛以提供密码隐藏与显示功能-->
                <div class="register-input"><label>
                    <input type="password" name="password" placeholder="&nbsp;密码"
                           class="register-password register-text">
                    <div class="little-tips tips-password">* 由字母、数字、特殊字符组成，长度为 6~16</div>
                </label></div>

                <div class="register-input"><label>
                    <input type="email" name="email" placeholder="&nbsp;邮箱" class="register-email register-text"
                           value="${ empty requestScope.user.email? "" : requestScope.user.email}">
                    <div class="little-tips tips-email">* e.g bookhouse@bookhouse.com</div>
                </label></div>

                <div class="register-input"><label>
                    <input type="text" name="imgVerifyCode" placeholder="&nbsp;图片验证码" class="verifyCode img-text">
                    <img id="imgVerifyCode" alt="验证码加载失败，请稍后重试" src="imgVerifyCode.jpg"/>
                    <div class="little-tips tips-imgver">* 恋恋世界第一</div>
                </label>
                </div>

                <%--                // TODO 将此 span 标签右对齐，红色--%>
                <span class="registerErrorMsg">Msg:一起来起舞吧${empty requestScope.registerErrorMsg ? "" : requestScope.registerErrorMsg}</span>

                <div class="register-button">
                    <button type="submit" class="register-btn">注&nbsp;&nbsp;册</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>