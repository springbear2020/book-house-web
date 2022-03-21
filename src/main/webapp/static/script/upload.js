window.onload = function (){
    $('.chooseImg').on('change',function (){
        // 获取文件路径
        // let filePath = $(this).val();
        let src = window.URL.createObjectURL(this.files[0]);
        $('.bookCover-img').attr('src',src);
        // console.log("世一恋！");
    })
}