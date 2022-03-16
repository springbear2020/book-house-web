<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>

    <%@include file="/pages/common/header.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/user.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/register.js"></script>

<%--    <script type="text/javascript">--%>
<%--        // 页面加载完成之后--%>
<%--        $(function () {--%>
<%--            // TODO 使用正则表达式验证各表单项信息是否合法--%>

<%--            // 给验证码图片绑定单击事件--%>
<%--            $("#imgVerifyCode").click(function () {--%>
<%--                // 用时间戳作参数以解决 Firefox 和 IE 的缓存问题--%>
<%--                this.src = "imgVerifyCode.jpg?date=" + new Date();--%>
<%--            });--%>

<%--            // 给获取邮箱验证码按钮绑定单击事件--%>
<%--            $("#emailVerifyCode").click(function () {--%>
<%--                let emailBtnObj = document.getElementById("emailVerifyCode");--%>
<%--                emailBtnObj.disabled = true;--%>
<%--                //TODO 发起 AJAX 请求由服务器发送验证码到邮箱，并设置图片验证码 1 分钟后才可获取--%>
<%--                alert("邮件已发送到您的邮箱,请注意查收!")--%>
<%--            });--%>
<%--        })--%>
<%--    </script>--%>
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
        <%--            <img alt="涩图已失效" src="https://wx2.sinaimg.cn/mw2000/003tUy6ply1guoegkvuymj60jg0jgqa002.jpg" class="middle-pic">--%>
        <%--        </div>--%>
<%--            <div>哈哈哈</div>--%>
        <div class="frame-login">
            <div class="login-title">欢&nbsp&nbsp迎&nbsp&nbsp注&nbsp&nbsp册</div>
            <form class="login-box" action="userServlet" method="post">
                <input type="hidden" name="action" value="register">

                <span id="error_msg" style="color: red ">注册错误信息显示</span>

                <!-- //TODO 给用户名输入框绑定失去焦点事件,发起 AJAX 请求请求服务器验证用户名是否可用 -->
                <div class="login-input"><label>
                    <input type="text" name="username" placeholder="&nbsp请输入用户名"
                           class="login-username login-text">
                    <div class="little-tips">*可使用数字、字母、下划线，但要以字母开头</div>
                </label></div>

                <!-- // TODO 此处应添加一只小眼睛以提供密码隐藏与显示功能-->
                <div class="login-input"><label>
                    <input type="text" name="password" placeholder="&nbsp请输入密码"
                           class="login-password login-text">
                    <div class="little-tips">*由长度为5到15位的字母、数字或下划线组成</div>
                </label></div>

                <div class="login-input"><label>
                    <input type="email" name="email" placeholder="&nbsp邮箱地址" class="login-password login-text">
                    <div class="little-tips">*请输入正确格式</div>
                </label></div>

                <div class="login-input"><label>
                    <input type="text" name="verifyCode" placeholder="&nbsp邮箱验证码" class="vercode">
                    <input type="button" id="emailVerifyCode" value="获取验证码" class="email-btn">
                    <div class="little-tips">*占位</div>
                    </label>
                    </div>

                <div class="login-input"><label>
                    <input type="text" name="imgCode" placeholder="&nbsp图片验证码" class="vercode img-text">
                    <img id="imgVerifyCode" alt="验证码加载失败，请稍后重试" src="imgVerifyCode.jpg"/>
                    <div class="little-tips">*验证码错误</div>
                    </label>
                    </div>


                <div class="login-button">
                    <button type="submit" class="login-btn">立即注册</button>
                    <a href="pages/user/login.jsp" class="re-login">返回登录</a>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom-content"></div>
</body>

</html>