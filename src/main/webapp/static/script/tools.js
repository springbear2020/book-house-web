/*
 * 自适应宽度 根据网页调整rem的值
 * 这是个立即执行函数
 * designWidth:设计稿的实际宽度值，需要根据实际设置
 * maxWidth:制作稿的最大宽度值，需要根据实际设置
 * 这段js的最后面有两个参数记得要设置，一个为设计稿实际宽度，一个为制作稿最大宽度，例如设计稿为750，最大宽度为750，则为(750,750)
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
        if (e.persisted) { // 浏览器后退的时候重新计算
            clearTimeout(tid);
            tid = setTimeout(refreshRem, 300);
        }
    }, false);

    if (doc.readyState === "complete") {
        doc.body.style.fontSize = "16px";
    } else {
        doc.addEventListener("DOMContentLoaded", function (e) {
            doc.body.style.fontSize = "16px";
        }, false);
    }
})(2160, 1440);







// 结合了 get 和 post 的终极形态，option 是对象 属性有 type url data success
let ajax = function (option) {
    // 创建异步对象
    let xhr = new XMLHttpRequest();

    // 如果是get 并且有数据
    if (option.type == 'get' && option.data) {
        option.url += '?';
        option.url += option.data;
        option.data = null;
    }

    // 请求行
    xhr.open(option.type, option.url);

    // 请求头(get可以省略 post不发数据也可以省略 虽然我之前发了数据但是忘写了也没出事 搞不懂)
    if (option.type == 'post' && option.data) {
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    }

    // 回调函数
    xhr.onreadystatechange = function () {
        // ↓这个if一定程度确保了数据的正确性
        if (xhr.readyState == 4 && xhr.status == 200) {
            let type = xhr.getResponseHeader('Content-type');
            // 是否为Json
            if (type.indexOf('json') != -1) {
                option.success(JSON.parse(xhr.responseText))
            }
            // 是否为XML
            else if (type.indexOf('xml') != -1) {
                option.success(xhr.responseXML);
            }
            // 普通字符串
            else {
                option.success(xhr.responseText);
            }
        }
    }

    // 请求主体 发送
    xhr.send(option.data);
};