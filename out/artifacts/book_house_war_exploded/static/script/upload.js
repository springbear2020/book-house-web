window.onload = function () {

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

    // 验证图书文件和封面文件是否有效
    $("#userUploadBook").click(function () {
        // 图书文件
        let $book = $(".chooseFile");
        let bookFileName = $book.val();
        if (!bookFileName) {
            alert("未选择图书文件，请您先选择 PDF 图书文件");
            return false;
        }
        if (!bookFileName.endsWith('.pdf')) {
            alert("图书文件不是 PDF 格式，请您重新选择");
            return false;
        }

        // 封面文件
        let $cover = $(".chooseImg");
        let coverFileName = $cover.val();
        if (!coverFileName) {
            alert("未选择图书封面，请您先选择封面图片文件");
            return false;
        }
        if (!(coverFileName.endsWith('.jpg') || coverFileName.endsWith('.png'))) {
            alert("封面图书文件不是 jpg 或 png 格式，请您重新选择封面文件");
            return false;
        }
        return true;
    });
}