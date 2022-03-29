// 将上传的图片封面显示到网页
$(function (){
    $('#img-choose').on('change', function () {
        let src = window.URL.createObjectURL(this.files[0]);
        let $img = $('.bk');
        $img.attr('src', src);
    })
})


