$(function () {
    let $bk = $('.pixabayManage');
    let $tb = $('.ad-table');
    let check = true;
    $bk.click(function () {
        if (check) {
            $tb.css('display', 'block');
            check = false;
        } else {
            $tb.css('display', 'none');
            check = true
        }
    })
})