$(function () {
    // 邮箱输入框的失焦事件
    let emailExists = false;
    $(".pwdFind-email").blur(function () {
        // 验证邮箱格式
        let $email = $(".pwdFind-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        let $tipsEmailObj = $(".tips-email");
        if (!emailReg.test($email) || $email.length <= 0) {
            $tipsEmailObj.css("color", "red");
            $tipsEmailObj.css("font-weight", "bold");
            $tipsEmailObj.text("* 邮箱格式不正确");
            return false;
        } else {
            $tipsEmailObj.css("color", "darkolivegreen");
            $tipsEmailObj.css("font-weight", "normal");
            $tipsEmailObj.text("* 邮箱格式正确");
        }

        // 发起 AJAX 请求服务器验证邮箱存在性
        $.ajax({
            url: "userServlet",
            data: "action=ajaxVerifyEmail&email=" + $email,
            type: "POST",
            // function 函数中一定要有参数以接收来自服务器的数据
            success: function (data) {
                if (data === "false") {
                    $tipsEmailObj.css("color", "red");
                    $tipsEmailObj.css("font-weight", "bold");
                    $tipsEmailObj.text("* 邮箱地址未注册账号，请重新输入")
                    emailExists = false;
                    return false;
                } else {
                    $tipsEmailObj.css("color", "darkolivegreen");
                    $tipsEmailObj.css("font-weight", "normal");
                    $tipsEmailObj.text("* 邮箱地址正确")
                    emailExists = true;
                }
            },
            dataType: "text"
        });
    });

    // 邮箱验证码失焦事件
    $(".pwdFind-emailVerifyCode").blur(function () {
        let $verifyCode = $(".pwdFind-emailVerifyCode").val();
        let $tipsObj = $(".tips-pwdFind");
        if ($verifyCode.length !== 6) {
            $tipsObj.css("color", "red");
            $tipsObj.css("font-weight", "bold");
            $tipsObj.text("* 验证码长度为 6 位字符");
            return false;
        } else {
            $tipsObj.css("color", "darkolivegreen");
            $tipsObj.css("font-weight", "normal");
            $tipsObj.text("* 点击获取验证码，邮件会发送至您的邮箱");
        }
    });

    // 获取邮箱验证码按钮单击事件
    $("#pwdFind-code-btn").click(function () {
        // 邮箱地址无效则不允许获取验证码
        let $email = $(".pwdFind-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        let tipsObj = $(".tips-email");
        if (!emailReg.test($email) || $email.length <= 0) {
            tipsObj.css("color", "red");
            tipsObj.css("font-weight", "bold");
            tipsObj.text("* 请输入您注册账号时使用的邮箱地址")
            return false;
        } else if (!emailExists) {
            tipsObj.css("color", "red");
            tipsObj.css("font-weight", "bold");
            tipsObj.text("* 邮箱地址未注册账号，请重新输入")
            return false;
        } else if (emailExists) {
            tipsObj.css("color", "darkolivegreen");
            tipsObj.css("font-weight", "normal");
        }

        let $btn = $("#pwdFind-code-btn");
        // 设置按钮不可点击
        $btn.attr('disabled', true);
        // 发起 ajax 请求让服务器发送随机验证码
        $.ajax({
            url: "emailServlet",
            data: "action=ajaxSendPasswordFindEmailCode&email=" + $email,
            type: "POST",
            dataType: "text",
            success: function (data) {
                if (data === "false") {
                    alert("验证码发送失败，请稍后重试！");
                }
            },
            error: function () {
                alert("验证码发送失败，请稍后重试！");
            }
        });
        // 获取验证码按钮倒计时，将这个事件锁起来
        let secondsNode = 60;
        let time = setInterval(function () {
            secondsNode--;
            $btn.val("重新获取（" + secondsNode + ")");
            $btn.css("background-color", "grey")
            if (secondsNode <= 0) {
                $btn.attr('disabled', false);
                $btn.val("获取验证码");
                $btn.css("background-color", "lightskyblue")
                clearInterval(time);
            }
        }, 1000)
    });

    // 给重置密码按钮绑定单击事件
    $("#resetPwdBtn").click(function () {
        // 再次验证各表单项格式
        // 验证邮箱格式
        let $email = $(".pwdFind-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        let $tipsEmailObj = $(".tips-email");
        if (!emailReg.test($email) || $email.length <= 0) {
            $tipsEmailObj.css("color", "red");
            $tipsEmailObj.css("font-weight", "bold");
            $tipsEmailObj.text("* 邮箱格式不正确");
            return false;
        } else {
            $tipsEmailObj.css("color", "darkolivegreen");
            $tipsEmailObj.css("font-weight", "normal");
            $tipsEmailObj.text("* 邮箱格式正确");
        }
        // 验证邮箱验证码
        let $verifyCode = $(".pwdFind-emailVerifyCode").val();
        let $tipsObj = $(".tips-pwdFind");
        if ($verifyCode.length !== 6) {
            $tipsObj.css("color", "red");
            $tipsObj.text("* 验证码长度为 6 位字符");
            return false;
        } else {
            $tipsObj.css("color", "darkolivegreen");
            $tipsObj.text("* 点击获取验证码，邮件会发送至您的邮箱");
        }
        // 验证密码格式以及两次密码是否一致
        let $pwd = $(".reset-pwd").val();
        let $rePwd = $(".re-reset-pwd").val();
        let $pwdTips = $(".tips-password");
        if ($pwd.length < 6 || $pwd.length > 16) {
            $pwdTips.css("color", "red");
            return false;
        } else if ($pwd !== $rePwd) {
            $pwdTips.css("color", "red");
            $pwdTips.css("font-weight", "bold");
            $pwdTips.text("两次输入的密码不一致，请重新输入")
            return false;
        } else {
            $pwdTips.css("color", "darkolivegreen");
            $pwdTips.css("font-weight", "normal");
            $pwdTips.text("* 至少一个数字、字母、字符（@#$%&），长度为 6~16");
        }

        return true;
    });
});