$(function (){
    // 上传头像
    // 将上传的头像显示到页面
    $('.chooseImg').on('change', function () {
        // 获取上传的图片的文件路径
        let src = window.URL.createObjectURL(this.files[0]);
        let $img = $('.user-head>img')
        // 修改头像的图片
        $img.attr('src', src);
    })
})
