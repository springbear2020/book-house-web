window.onload = function (){
    $("#imgVerifyCode").click(function () {
        // 用时间戳作参数以解决 Firefox 和 IE 的缓存问题
        this.src = "imgVerifyCode.jpg?date=" + new Date();
    });

    // 给获取邮箱验证码按钮绑定单击事件
    $("#emailVerifyCode").click(function () {
        let emailBtnObj = document.getElementById("emailVerifyCode");
        emailBtnObj.disabled = true;
        //TODO 发起 AJAX 请求由服务器发送验证码到邮箱，并设置图片验证码 1 分钟后才可获取
        alert("邮件已发送到您的邮箱,请注意查收!")
    });

    var loginText = document.getElementsByClassName("login-text");
    var littleTips = document.getElementsByClassName("little-tips");

    //用户名的相关事件
    loginText[0].addEventListener('focus',function (){
        littleTips[0].style.color = "darkolivegreen";
        // console.log("我永远喜欢觉");
    },false);
    loginText[0].addEventListener('blur',function (){
        var ajaxObject = {
            type : "host";
            url : "#";
            data : loginText[0].value;
            success : function (response){
                console.log(response);
            }
        }
        ajax(ajaxObject);
        littleTips[0].style.color = "red";
        // console.log("我永远喜欢恋恋");
    },false);

}