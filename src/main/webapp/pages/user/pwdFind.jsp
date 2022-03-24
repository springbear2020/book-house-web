<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/19
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/pwdFind.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/pwdFind.js"></script>

    <%-- 用户修改密码成功提示信息 --%>
    <c:if test="${ not empty requestScope.updatePwdSuccessMsg}">
        <div class="success-tips">${requestScope.updatePwdSuccessMsg}</div>
        <% request.removeAttribute("updatePwdErrorMsg"); %>
        <% request.removeAttribute("updatePwdSuccessMsg"); %>
    </c:if>
    <%-- 用户修改密码提示信息 --%>
    <c:if test="${ not empty requestScope.updatePasswordMsg}">
        <script type="text/javascript">alert("${requestScope.updatePasswordMsg}")</script>
        <% request.removeAttribute("updatePasswordMsg"); %>
        <% request.removeAttribute("updatePwdSuccessMsg"); %>
    </c:if>
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<div class="middle">
    <div class="container">
        <ul class="frame-title">
            <li class="title-pwdFind">忘记密码</li>
        </ul>
        <div class="pwdFind">
            <%-- 找回密码表单 --%>
            <form action="userServlet" method="post">
                <input type="hidden" name="action" value="updatePassword">
                <label>
                    <input class="input-text pwdFind-email" placeholder="请输入邮箱" name="email">
                </label>
                <div class="little-tips tips-email">* 请输入您注册账号时使用的邮箱地址</div>
                <div class="input-ver">
                    <label>
                        <input class="input-text-ver pwdFind-emailVerifyCode" placeholder="邮箱验证码" name="emailVerifyCode">
                    </label>
                    <input type="button" id="pwdFind-code-btn" class="btn btn-ver" value="获取验证码">
                    <div class="little-tips tips-pwdFind">* 点击获取验证码，邮件会发送至您的邮箱</div>
                </div>
                <label>
                    <input type="password" name="password" placeholder="请输入新密码" class="input-text reset-pwd">
                    <input type="password" name="password" placeholder="请再次输入密码" class="input-text re-reset-pwd">
                    <div class="little-tips tips-password">* 至少包含一个数字、字母和特殊字符，长度为 6~16</div>
                </label>
                <input type="submit" id="resetPwdBtn" value="重置密码" class="btn-next">
            </form>
            <button class="btn-back" onclick="window.location.href='pages/user/login.jsp'">返&nbsp;回</button>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>