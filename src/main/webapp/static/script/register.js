$(function () {
    // 图片验证码单击事件
    $("#imgCodeBtn").click(function () {
        // 加上时间戳作为参数以解决 Firefox、IE 等浏览器缓存导致不能刷新问题
        this.src = "imgVerifyCode.jpg?date=" + new Date();
    });

    // 用户名输入框失焦事件
    $(".register-username").blur(function () {
        // 验证用户名格式
        let username = $(".register-username").val();
        let usernameExp = new RegExp("^[a-zA-Z][a-zA-Z0-9_-]{0,15}$");
        let obj = $(".tips-username");
        if (!usernameExp.test(username)) {
            obj.css("color", "red");
            return false;
        }
        // 发起 AJAX 请求服务器验证用户名存在性
        $.ajax({
            url: "userServlet",
            data: "action=ajaxVerifyUsername&username=" + username,
            type: "POST",
            // function 函数中一定要有参数以接收来自服务器的数据
            success: function (data) {
                if (data === "true") {
                    obj.css("color", "red");
                    obj.text("用户名已存在")
                } else {
                    obj.css("color", "darkolivegreen");
                    obj.text("用户名可用")
                }
            },
            dataType: "text"
        });
    });

    // 密码输入框的失焦事件
    $(".register-password").blur(function () {
        // 验证密码格式
        let password = $(".register-password").val();
        let pwdReg = new RegExp("^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$");
        let obj = $(".tips-password");
        if (!pwdReg.test(password)) {
            obj.css("color", "red");
        } else {
            obj.css("color", "darkolivegreen");
        }
    });

    // 邮箱输入框的失焦事件
    $(".register-email").blur(function () {
        // 验证邮箱格式
        let email = $(".register-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        let obj = $(".tips-email");
        if (!emailReg.test(email)) {
            obj.css("color", "red");
        } else {
            obj.css("color", "darkolivegreen");
        }
    })

    // 邮箱验证码输入框的失焦事件
    $(".emailVerifyCode").blur(function () {
        // 验证验证码格式
        let verifyCode = $(".emailVerifyCode").val()
        let obj = $(".tips-emailCode");
        if (!verifyCode.length > 0) {
            obj.css("color", "red");
        } else {
            obj.css("color", "darkolivegreen");
        }
    });

    // 图片验证码输入框的失焦事件
    $(".imgVerifyCode").blur(function () {
        // 验证验证码格式
        let verifyCode = $(".imgVerifyCode").val()
        let obj = $(".tips-imgCode");
        if (!verifyCode.length > 0) {
            obj.css("color", "red");
        } else {
            obj.css("color", "darkolivegreen");
        }
    });

    // 辅助参数
    let emailLocked = false;
    // 获取邮箱验证码按钮单击事件
    $("#emailCodeBtn").click(function () {
        if(emailLocked){
            return false;
        }
        else{
            // 邮箱地址无效则不允许获取验证码
            let email = $(".register-email").val();
            let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
            let obj = $(".tips-email");
            if (!emailReg.test(email)) {
                obj.css("color", "red");
                return false;
            } else {
                obj.css("color", "darkolivegreen");
            }

            // 发起 ajax 请求让服务器发送随机验证码
            $.ajax({
                url: "userServlet",
                data: "action=ajaxSendEmailCode&email=" + email,
                type: "POST",
                dataType: "text",





                success: function (data) {
                    if (data === "true") {
                        alert("验证码已成功发送到您的邮箱，请注意查收哦！")
                        // 将这个事件锁起来
                        emailLocked = true;
                        let secondsNode = 60;
                        let time = setInterval(function (){
                            secondsNode--;
                            $("#emailCodeBtn").val("已发送（"+secondsNode+")");
                            $("#emailCodeBtn").css("background-color","grey")
                            if(secondsNode <= 0){
                                $("#emailCodeBtn").val("获取验证码");
                                $("#emailCodeBtn").css("background-color","cyan")
                                emailLocked = false;
                                clearInterval(time);
                            }
                        },1000)
                    } else {
                        alert("验证码发送失败，请稍后重试！")
                    }
                },
                error: function () {
                    alert("验证码发送失败，请稍后重试！")
                }
            });
        }


    });

    //眼睛图片单击事件
    //辅助参数
    let eyeClosed = false;
    $(".pas-eye").click(function (){
        if(eyeClosed){
            //如果闭眼 则睁眼
            //由可见变为不可见
            this.src = "static/pic/eye.png"
            // $(".register-password").type = "text";
            $(".register-password").prop('type','password');
            eyeClosed = false;
        }
        else{
            //如果睁眼 则闭眼
            //由不可见变为可见
            this.src = "static/pic/eye_closed.png"
            // $(".register-password").type = "text";
            $(".register-password").prop('type','text');
            eyeClosed = true;
        }
    })

    // 注册按钮单击事件
    $(".register-btn").click(function () {
        /* 再次验证各表单项数据格式，不符合格式则阻止表单提交 */
        // 验证用户名格式
        let username = $(".register-username").val();
        let usernameExp = new RegExp("^[a-zA-Z][a-zA-Z0-9_-]{0,15}$");
        let usernameObj = $(".tips-username");
        if (!usernameExp.test(username)) {
            usernameObj.css("color", "red");
            return false;
        }
        // 验证密码格式
        let password = $(".register-password").val();
        let pwdReg = new RegExp("^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$");
        let pwdObj = $(".tips-password");
        if (!pwdReg.test(password)) {
            pwdObj.css("color", "red");
            return false;
        } else {
            pwdObj.css("color", "darkolivegreen");
        }
        // 验证邮箱格式
        let email = $(".register-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        let emailObj = $(".tips-email");
        if (!emailReg.test(email)) {
            emailObj.css("color", "red");
            return false;
        } else {
            emailObj.css("color", "darkolivegreen");
        }
        // 验证邮箱验证码格式
        let emailCode = $(".emailVerifyCode").val()
        let emailCodeObj = $(".tips-emailCode");
        if (!emailCode.length > 0) {
            emailCodeObj.css("color", "red");
            return false;
        } else {
            emailCodeObj.css("color", "darkolivegreen");
        }
        // 验证图片验证码格式
        let imgCode = $(".imgVerifyCode").val()
        let imgCodeObj = $(".tips-imgCode");
        if (!imgCode.length > 0) {
            imgCodeObj.css("color", "red");
            return false;
        } else {
            imgCodeObj.css("color", "darkolivegreen");
        }

        return true;
    });
});