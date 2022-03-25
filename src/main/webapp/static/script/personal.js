$(function (){
    let $img = $('.change-hd>img');
    let $imgTrue = $('.change-hd');
    // 上传头像
    // 将上传的头像显示到页面
    $('.chooseImg').on('change', function () {
        // 获取上传的图片的文件路径
        let src = window.URL.createObjectURL(this.files[0]);
        // 修改头像的图片
        $img.attr('src', src);
    })
    // 头像的鼠标移入事件
    $imgTrue.mouseover(function (){
        $imgDiv.css('display','block');
    });
    $imgTrue.mouseleave(function (){
        $imgDiv.css('display','none');
    });

    // 神奇的js允许你先调用再定义变量
    let $imgDiv = $('.change-hd>div');

    let eyeClosed = false;
    $(".pas-eye").click(function () {
        if (eyeClosed) {
            // 如果闭眼 则睁眼，由可见变为不可见
            this.src = "static/img/eye.png"
            $(".data-pwd").prop('type', 'password');
            eyeClosed = false;
        } else {
            // 如果睁眼 则闭眼，由不可见变为可见
            this.src = "static/img/eye_closed.png"
            $(".data-pwd").prop('type', 'text');
            eyeClosed = true;
        }
    })


    let $btnSure = $('.change-sure');
    let $btnCancel = $('.change-cancel');
    // 点击修改资料
    $('.per-change-check').click(function (){
        // 让所有输入框都可以被修改
        $('.per-data-text').attr('disabled',false);
        $('.per-data-sex').attr('disabled',false);
        // 让两个按钮出现
        $btnSure.css('display','block');
        $btnCancel.css('display','block');
    })
    // 取消按钮的点击事件
    $btnCancel.click(function (){
        // 让所有输入框锁起来
        $('.per-data-text').attr('disabled',true);
        $('.per-data-sex').attr('disabled',true);
        // 让两个按钮消失
        $btnSure.css('display','none');
        $btnCancel.css('display','none');
    })
    // 保存按钮的点击事件
    $btnSure.click(function (){
        // 让两个按钮消失
        $btnSure.css('display','none');
        $btnCancel.css('display','none');
        // 让所有输入框锁起来
        $('.per-data-text').attr('disabled',true);
        $('.per-data-sex').attr('disabled',true);
    })

})
