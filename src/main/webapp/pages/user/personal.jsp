<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/23
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>个人信息</title>
    <%@include file="/pages/common/base.jsp" %>
    <script type="text/javascript" src="static/script/tools.js"></script>
    <script type="text/javascript" src="static/script/personal.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <link rel="stylesheet" type="text/css" href="static/css/personal.css">

    <%-- 根据 request 域中的 userInfo 信息显示用户性别 --%>
    <script type="text/javascript">
        $(function () {
            let $sex = "${sessionScope.userInfo.sex}";
            if ($sex === "男") {
                // console.log($(".sex-male"));
                $(".sex-male").attr("checked", true);
            } else if ($sex === "女") {
                $(".sex-female").attr("checked", 'checked');
            } else {
                $(".sex-secret").attr("checked", 'checked');
            }
        })
    </script>
    <%-- 提示信息 --%>
    <%@include file="/pages/common/notice.jsp" %>
    <c:if test="${not empty sessionScope.noticeMsg}">
        <script type="text/javascript">noticeShow()</script>
        <% session.removeAttribute("noticeMsg"); %>
    </c:if>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="middle-container">
        <div class="head-frame">
            <div class="user-head">
                <label class="change-hd">
                    <img src="${sessionScope.user.portraitPath}" alt="头像加载失败">
                    <div>更换头像</div>
                    <%-- 更换头像表单 --%>
                    <form action="transferServlet?action=uploadPortrait&userId=${sessionScope.user.id}" method="post" enctype="multipart/form-data">
                        <input type="file" name="head_img" accept="image/jpeg,image/png" class="chooseImg"
                               style="opacity: 0">
                        <button type="submit" class="updatePortraitBtn">确认更换</button>
                    </form>
                </label>
            </div>
            <div class="user-data-frame">
                <div class="user-data-top">
                    <div class="user-data-top-username">${sessionScope.userInfo.nickname}</div>
                    <p class="user-data-top-time">${sessionScope.user.registerDate}</p>
                    <p>加入&nbsp;Book&nbsp;House</p>
                </div>
                <div class="user-data-center">
                    <ul>
                        <li>
                            <div class="user-data-num">${sessionScope.user.score}</div>
                            <div class="user-data-name">积分</div>
                            <div class="sp"></div>
                        </li>
                        <li>
                            <div class="user-data-num">${sessionScope.userInfo.collections}</div>
                            <div class="user-data-name">收藏</div>
                            <div class="sp"></div>
                        </li>
                        <li>
                            <div class="user-data-num">${sessionScope.userInfo.uploads}</div>
                            <div class="user-data-name">上传</div>
                            <div class="sp"></div>
                        </li>
                        <li>
                            <div class="user-data-num">${sessionScope.userInfo.downloads}</div>
                            <div class="user-data-name">下载</div>
                            <div class="sp"></div>
                        </li>
                    </ul>
                </div>
                <div class="user-data-bottom">
                    <div class="user-Signature">个性签名</div>
                    <p class="user-Signature-data">${sessionScope.userInfo.signature}</p>
                </div>
            </div>
        </div>
        <div class="per-frame">
            <h1 class="per-title">个人资料</h1>
            <%-- 个人资料修改表单 --%>
            <form action="userInfoServlet" method="post">
                <button type="submit" disabled="disabled" class="per-change-check">保存</button>
                <div class="per-sp"></div>

                <input type="hidden" name="action" value="saveUserInfo">
                <input type="hidden" name="userId" value="${sessionScope.user.id}">
                <ul class="per-container">
                    <li>
                        <div class="per-data-name">用户昵称</div>
                        <label><input name="nickname" class="per-data-text" type="text"
                                      value="${sessionScope.userInfo.nickname}"></label>
                    </li>
                    <li>
                        <div class="per-data-name">性别</div>
                        <label>
                            <input type="radio" name="sex" value="男" class="per-data-sex sex-b sex-male">
                            <div class="per-data-sex">男</div>
                            <input type="radio" name="sex" value="女" class="per-data-sex sex-b sex-female">
                            <div class="per-data-sex">女</div>
                            <input type="radio" name="sex" value="保密" class="per-data-sex sex-b sex-secret">
                            <div class="per-data-sex">保密</div>
                        </label>
                    </li>
                    <li>
                        <div class="per-data-name">出生日期</div>
                        <label><input name="birth" class="per-data-text" type="date"
                                      value="${sessionScope.userInfo.birth}"></label></li>
                    <li class="area-whole">
                        <div class="per-data-name">所在地区</div>
                        <label><input name="location" class="per-data-text area-data" type="text"
                                      value="${sessionScope.userInfo.location}" readonly></label>
                        <div class="area-frame">
                            <ul class="area-left"></ul>
                            <ul class="area-right"></ul>
                        </div>
                    </li>
                    <li id="per-data-sign">
                        <div class="per-data-name">个性签名</div>
                        <label><input name="signature" type="text" maxlength="40"
                                      class="per-data-text per-data-Signature"
                                      value="${sessionScope.userInfo.signature}"></label>
                    </li>
                </ul>
            </form>
        </div>
        <div class="data-frame">
            <h1 class="per-title">账号信息</h1>
            <div class="per-sp"></div>
            <form>
                <ul class="per-container">
                    <li>
                        <div class="us-data-name">用户名</div>
                        <label><input name="username" class="us-data-text" type="text" disabled
                                      value="${sessionScope.user.username}"></label>
                    </li>
                    <li>
                        <div class="us-data-name">密码</div>
                        <label><input name="password" class="us-data-text data-pwd" type="password" disabled
                                      value="${sessionScope.user.password}"></label>
                        <img class="pas-eye" src="static/img/eye.png" alt="图片加载失败"></li>
                    <li>
                        <div class="us-data-name">邮箱</div>
                        <label><input name="email" class="us-data-text" type="text" disabled
                                      value="${sessionScope.user.email}"></label>
                    </li>
                    <li class="log-record-li"><a href="recordServlet?action=showLoginLog&userId=${sessionScope.user.id}"
                                                 class="log-record log-btn">登录记录</a></li>
                    <li class="log-out-li"><a class="log-out log-btn">账号注销</a></li>
                    <li class="log-out-li"><a href="pages/user/pwdFind.jsp" class="log-out log-btn">修改密码</a></li>
                </ul>
            </form>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
