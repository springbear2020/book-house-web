window.onload = function () {
    // 给用户名输入框绑定失去焦点事件，先使用正则表达式验证格式，后发起 AJAX 请求服务器验证用户名存在性
    $(".login-text").first().blur(function () {
        let username = this.value;
        // TODO 使用正则表达式验证用户名格式正确性
        $.ajax({
            url: "userServlet",
            data: "action=ajaxVerifyUsername&username=" + username,
            type: "POST",
            // function 函数中一定要有参数以接收来自服务器的数据
            success: function (data) {
                // TODO 此处应将服务器返回的 data 数据回显提示用户
                alert(data)
            },
            dataType: "text"
        });
    });

    // TODO 给密码输入框绑定失去焦点事件，使用正则表达式验证格式


    // TODO 给获取邮箱验证码按钮绑定 ajax 请求事件
    $("#emailVerifyCode").click(function () {
        $.ajax({
            url: "userServlet",
            data: "action=ajaxGetVerifyCode",
            type: "POST",
            success: function (data) {
                // TODO 友好用户验证码发送情况
                alert(data)
            }
        });
    });

    // 图片验证码点击事件刷新验证码
    $("#imgVerifyCode").click(function () {
        // 用时间戳作参数以解决 Firefox 和 IE 的缓存问题
        this.src = "imgVerifyCode.jpg?date=" + new Date();
    });
}