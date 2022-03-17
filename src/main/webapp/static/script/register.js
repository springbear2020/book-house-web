window.onload = function () {
    // 给用户名输入框绑定失去焦点事件，先使用正则表达式验证格式，后发起 AJAX 请求服务器验证用户名存在性
    $(".register-username").blur(function () {
        let username = this.value
        let regExp = new RegExp("^[a-zA-Z][a-zA-Z0-9_-]{0,15}$");
        if (!regExp.test(username)) {
            $("span.registerErrorMsg").text("用户名格式不正确")
            return false;
        } else {
            $("span.registerErrorMsg").text("")
        }
        $.ajax({
            url: "userServlet",
            data: "action=ajaxVerifyUsername&username=" + username,
            type: "POST",
            // function 函数中一定要有参数以接收来自服务器的数据
            success: function (data) {
                $("span.registerErrorMsg").text(data)
            },
            dataType: "text"
        });
    });

    // 注册按钮单击事件，验证表单项格式
    $(".register-btn").click(function () {
        // // 验证用户名格式
        // let username = $(".register-username").val();
        // let usernameExp = new RegExp("^[a-zA-Z][a-zA-Z0-9_-]{0,15}$");
        // if (!usernameExp.test(username)) {
        //     $("span.registerErrorMsg").text("用户名格式不正确")
        //     return false;
        // } else {
        //     $("span.registerErrorMsg").text("")
        // }
        // // 验证密码格式
        // let password = $(".register-password").val();
        // let pwdReg = new RegExp("^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$");
        // if (!pwdReg.test(password)) {
        //     $("span.registerErrorMsg").text("密码格式不正确");
        //     return false;
        // } else {
        //     $("span.registerErrorMsg").text("")
        // }
        // // 验证邮箱格式
        // let email = $(".register-email").val();
        // let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        // if (!emailReg.test(email)) {
        //     $("span.registerErrorMsg").text("邮箱格式不正确");
        //     return false;
        // } else {
        //     $("span.registerErrorMsg").text("")
        // }
        // // 验证验证码格式
        // let verifyCode = $(".verifyCode").val()
        // console.log(verifyCode === "")
        // if (!verifyCode.length > 0) {
        //     $("span.registerErrorMsg").text("验证码不能为空");
        //     return false;
        // } else {
        //     $("span.registerErrorMsg").text("")
        // }
        // return true;
    });

    // 用户名输入框的失焦事件
    $(".register-username").blur(function (){
        // console.log("我永远喜欢恋恋");
        // 验证用户名格式
        let username = $(".register-username").val();
        let usernameExp = new RegExp("^[a-zA-Z][a-zA-Z0-9_-]{0,15}$");
        if (!usernameExp.test(username)) {
            $(".tips-username").text("用户名格式不正确");
            $(".tips-username").css("color","red");
            // return false;
        } else {
            $(".tips-username").html("不知道写啥 等后端");
            $(".tips-username").css("color","darkolivegreen");
        }
    });

    // 密码输入框的失焦事件
    $(".register-password").blur(function (){
        // 验证密码格式
        let password = $(".register-password").val();
        let pwdReg = new RegExp("^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$");
        if (!pwdReg.test(password)) {
            $(".tips-password").text("密码格式不正确");
            $(".tips-password").css("color","red");
            // return false;
        } else {
            $(".tips-password").text("* 由字母、数字、特殊字符组成，长度为 6~16")
            $(".tips-password").css("color","darkolivegreen");
        }
    });

    // 邮箱输入框的失焦事件
    $(".register-email").blur(function (){
        // 验证邮箱格式
        let email = $(".register-email").val();
        let emailReg = new RegExp("^([a-z0-9_-]+)@([\\da-z-]+)\\.([a-z]{2,6})$");
        if (!emailReg.test(email)) {
            $(".tips-email").text("邮箱格式不正确");
            $(".tips-email").css("color","red");
            return false;
        } else {
            $(".tips-email").text("所以说这里为什么要写东西");
            $(".tips-email").css("color","darkolivegreen");
        }
    })

    // 验证码输入框的失焦事件
    $(".verifyCode").blur(function (){
        // 验证验证码格式
        let verifyCode = $(".verifyCode").val()
        console.log(verifyCode === "")
        if (!verifyCode.length > 0) {
            $(".tips-imgver").text("验证码不能为空");
            $(".tips-imgver").css("display","block");
            $(".tips-imgver").css("color","red");
            // return false;
        } else {
            $(".tips-imgver").text("就看后端了");
        }
    })

}
