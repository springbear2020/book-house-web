window.onload = function (){
    $('.chooseImg').on('change',function (){
        // 获取文件路径
        // let filePath = $(this).val();
        let src = window.URL.createObjectURL(this.files[0]);
        let $img = $('.bookCover-img')
        $('.img-border>div').css('display','none');
        $img.attr('src',src);
        $img.css('display','block');
        $('.img-border').css('border','0');
        // $('.bookCover-img').attr('alt','图片加载失败');
        // console.log("世一恋！");
    })

    $('.chooseFile').on('change',function (){
        let filePath = $(this).val();
        filePath = filePath.slice(12);
        $('.fileInf').html(filePath);
    })
}