window.onload = function () {
    // 密码框眼睛图片单击事件
    let eyeClosed = false;
    $(".pas-eye").click(function () {
        if (eyeClosed) {
            // 如果闭眼则睁眼，由可见变为不可见
            this.src = "static/img/eye.png"
            $(".login-password").prop('type', 'password');
            eyeClosed = false;
        } else {
            // 如果睁眼 则闭眼，由不可见变为可见
            this.src = "static/img/eye_closed.png"
            $(".login-password").prop('type', 'text');
            eyeClosed = true;
        }
    })

    // 用户名或密码为空则不允许提交表单
    $("#loginBtn").click(function () {
        let usernameOrEmail = $(".login-username").val();
        let password = $(".login-password").val();
        if (usernameOrEmail.length === 0) {
            alert("用户名不允许为空")
            return false;
        }
        if (password.length === 0) {
            alert("密码不允许为空")
            return false;
        }
        return true;
    });
}