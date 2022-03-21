window.onload = function (){
    $('.chooseImg').on('change',function (){
        let src = window.URL.createObjectURL(this.files[0]);
        let $img = $('.bookCover-img')
        $('.img-border>div').css('display','none');
        $img.attr('src',src);
        $img.css('display','block');
        $('.img-border').css('border','0');
    })

    $('.chooseFile').on('change',function (){
        let filePath = $(this).val();
        filePath = filePath.slice(12);
        $('.fileInf').html(filePath);
    })
}