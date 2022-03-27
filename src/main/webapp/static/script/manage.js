
$(function (){
    // 将上传的图片封面显示到网页
    $('.chooseImg').on('change', function () {
        let src = window.URL.createObjectURL(this.files[0]);
        let $img = $('.bookCover-img')
        $('.img-border>div').css('display', 'none');
        $img.attr('src', src);
        $img.css('display', 'block');
        $('.img-border').css('border', '0');
    })

    // 将上传的图书名字显示到网页
    $('.chooseFile').on('change', function () {
        let filePath = $(this).val();
        filePath = filePath.slice(12);
        $('.fileInf').html(filePath);
    })

    $('.autoFill').click(function (){
        let parentTd = $(this).parent().parent();
        let userId = parentTd.find(".td-userId");
        let username = parentTd.find(".td-username");
        $(".form-userId").val(userId.text());
        $(".form-username").val(username.text());
        console.log(userId.html());
        console.log(username.text());
    });


    // 上传按钮的点击事件
    $(".upload-btn").click(function (){
        // 不知道有没有用 姑且试试
        // 在点击的时候将它们的锁解除
        $(".form-username").attr('disabled',false);
        $(".form-userId").attr('disabled',false);
        $(".form-points").attr('disabled',false);

        // 过一会重新锁上
        setTimeout(function (){
            $(".form-username").attr('disabled',true);
            $(".form-userId").attr('disabled',true);
            $(".form-points").attr('disabled',true);
        },500)
    })

})


