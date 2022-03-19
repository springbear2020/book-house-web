<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/19
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="../../static/css/pwdFind.css">
    <script type="text/javascript" src="../../static/script/tools.js"></script>
    <%--    <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>--%>
    <script type="text/javascript" src="../../static/script/pwdFind.js"></script>
</head>
<body>
<div class="top-content">
    <div class="title"><img class="盗版" src="https://user.mihoyo.com/t_1646801180130/src/resources/images/miHoYo_Logo_451cbfd2.png"></div>
</div>
<div class="middle">
    <div class="container">
        <div class="frame">
            <ul class="frame-title"><li class="title-pwdFind">找回密码</li></ul>
            <div class="pwdFind">
                <form>
                    <div class="ver-tips">请输入新密码</div>
                    <input class="input-text-set" placeholder="由任意字符组成，长度为 6~16" name="password">
                    <img class="pas-eye" src="../../static/img/eye.png" alt="图片加载失败">
                    <div class="little-tips">×内容不能为空</div>
<%--                    <button class="btn-next">下一步</button>--%>
                    <%--          <button class="btn-back">返&nbsp;回</button>--%>
                </form>
                <button class="btn-next">确&nbsp;认</button>
<%--                <button class="btn-back">返&nbsp;回</button>--%>
            </div>


        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>