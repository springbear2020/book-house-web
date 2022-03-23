$(function (){
    // 如果文本超出框外就显示“显示”
    (function (){
        let $textP = $(".inf-right>li>p");
        // console.log($textP);
        // console.log($textP[0]);
        // console.log($($textP[0]));
        let $textS = $(".inf-right>li>span");
        let i;
        let thisHeight;
        // 获取rem值
        let rem = parseInt(window.getComputedStyle(document.documentElement)["fontSize"]);
        // 遍历所有文本 检测是否有长度超标的
        for(i = 0; i < $textP.length; i++){
            thisHeight = $($textP[i]).height();
            // wordWidth = $textP[i].scrollHeight;
            if(thisHeight > rem){
                $($textP[i]).css('height','1rem');
                $($textS[i]).css('display','block');
                $($textS[i]).click(function (){
                    if($(this).text() ==='显示'){
                        // console.log(i);
                        // console.log(thisHeight);
                        // $($textP[i]).css('height',);
                        let $pre = $(this).prev();
                        $pre.css('height',$pre[0].scrollHeight);
                        // console.log($pre[0].scrollHeight);
                        $(this).text('隐藏');
                    }else{
                        let $pre = $(this).prev();
                        $($pre).css('height','1rem');
                        $(this).text('显示');
                    }
                })
            }
        }
    }());
})