window.onload = function (){
    let $srText = $('.search-text');
    let $srList = $('.search-list');
    // 搜索框的聚焦事件
    $srText.focus(function (){
        let value = $srText.val();
        // 如果框内没有输入东西就不显示下拉框
        if(value != ''){
            $srList.css('display','block');
        }
    })

    // 监听搜索框内容的变化
    $srText.bind('input porpertychange',function (){
        let value = $srText.val();
        // 如果框内变成了空的就不显示下拉框
        if(value != ''){
            $srList.css('display','block');
        }else{
            $srList.css('display','none');
        }
    })

    // 搜索框的失焦事件
    $srText.blur(function (){
        // 隐藏下拉框
        $('.search-list').css('opacity','0');
        setTimeout(function (){
            $srList.css('display','none');
            $srList.css('opacity','1');
        },100);
        // $('.search-list').css('display','none');
    })

    $('.search-li').click(function (){
        let value = $(this).text();
        $('.search-text').val(value);
    })
}