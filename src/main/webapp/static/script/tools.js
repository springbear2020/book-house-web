/*
 * 自适应宽度 根据网页调整 rem 的值
 * 这是个立即执行函数
 * designWidth:设计稿的实际宽度值，需要根据实际设置
 * maxWidth:制作稿的最大宽度值，需要根据实际设置
 * 这段 js 的最后面有两个参数记得要设置，一个为设计稿实际宽度，一个为制作稿最大宽度，例如设计稿为 750，最大宽度为 750，则为 (750,750)
 */
(function (designWidth, maxWidth) {
    let doc = document,
        win = window,
        docEl = doc.documentElement,
        remStyle = document.createElement("style"),
        tid;

    function refreshRem() {
        let width = docEl.getBoundingClientRect().width;
        maxWidth = maxWidth || 540;
        width > maxWidth && (width = maxWidth);
        let rem = width * 100 / designWidth;
        remStyle.innerHTML = 'html{font-size:' + rem + 'px;}';
    }

    if (docEl.firstElementChild) {
        docEl.firstElementChild.appendChild(remStyle);
    } else {
        let wrap = doc.createElement("div");
        wrap.appendChild(remStyle);
        doc.write(wrap.innerHTML);
        wrap = null;
    }
    // 要等 wiewport 设置好后才能执行 refreshRem，不然 refreshRem 会执行 2 次
    refreshRem();

    win.addEventListener("resize", function () {
        clearTimeout(tid); // 防止执行两次
        tid = setTimeout(refreshRem, 300);
    }, false);

    win.addEventListener("pageshow", function (e) {
        // 浏览器后退的时候重新计算
        if (e.persisted) {
            clearTimeout(tid);
            tid = setTimeout(refreshRem, 300);
        }
    }, false);

    if (doc.readyState === "complete") {
        doc.body.style.fontSize = "16px";
    } else {
        doc.addEventListener("DOMContentLoaded", function () {
            doc.body.style.fontSize = "16px";
        }, false);
    }
})(2160, 4320);

$(function () {
    // 头像的鼠标覆盖事件
    $('.head_img').mouseover(function () {
        //显示下拉框
        $('.self-frame').css('display', 'block');
    })
// 鼠标离开事件
    $('.top-self').mouseleave(function () {
        //隐藏下拉框
        $('.self-frame').css('display', 'none');
    })

});

// 让提示信息滑动入场并自动退场的函数
function noticeShow(){
    // 设置滑动入场的动画
    $('.notice').animate({top:'0.3rem'});
    // 设置定时器 让信息在指定时间后退场
    setTimeout(function (){
        $('.notice').animate({top:'-3rem'});
    },2000)
}
