window.onload = function () {
    let $srText = $('.search-text');
    let $srList = $('.search-list');
    // 搜索框的聚焦事件
    $srText.focus(function () {
        // let value = $srText.val();
        // 如果框内没有输入东西就不显示下拉框
        // if(value !== ''){
        $srList.css('display', 'block');
        // }
    })

    // 监听搜索框内容的变化
    $srText.bind('input property change',function (){
        let value = $srText.val();
        // 如果框内变成了空的就不显示下拉框
        if(value !== ''){
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

    // 点击搜索框以外的地方隐藏下拉框
    $(document).bind('click', function (e) {
        let elem = e.target;
        // 循环判断至根节点
        while (elem) {
            if (elem.className && elem.className === "search-form") {
                return;
            }
            elem = elem.parentNode;
        }
        $srList.css('display', 'none');
    })

    $('.search-li').click(function () {
        let value = $(this).text();
        $('.search-text').val(value);
    })

    let $srWord = $('.search-word');
    // 搜索词条的鼠标覆盖事件
    $srWord.mouseover(function () {
        $(this).css('background-color', 'grey');
        $(this).css('color', 'white');
        console.log("世一恋！");
    })

    // 搜索词条的鼠标离开事件
    $srWord.mouseleave(function () {
        // 确认该元素是否被点击过
        if (this.choose == null || this.choose === false) {
            $(this).css('background-color', 'white');
            $(this).css('color', 'black');
        } else {
            $(this).css('background-color', '#ddd');
            $(this).css('color', 'black');
        }
    })

    $srWord.click(function () {
        if (this.choose == null || this.choose === false) {
            $(this).css('background-color', '#ddd');
            this.choose = true;
        } else {
            $(this).css('background-color', 'white');
            this.choose = false;
        }
        // 阻止下拉框消失
        setTimeout(function () {
            $srList.css('display', 'block');
        }, 100)
    })

    // 头像的鼠标覆盖事件
    $('.head_img').mouseover(function (){
        //显示下拉框
        $('.self-frame').css('display','block');
    })
    // 鼠标离开事件
    $('.top-self').mouseleave(function (){
        //隐藏下拉框
        $('.self-frame').css('display','none');
    })

    // // 给搜索按钮绑定单击事件
    // $("#searchBookByTitle").click(function () {
    //     // 获取输入框中的内容，内容为空则阻止表单提交
    //     let $searchText = $(".search-text").val();
    //     if ($searchText.length === 0) {
    //         alert("书名不能为空，请重新输入")
    //         return false;
    //     }
    //     return true;
    // });
}