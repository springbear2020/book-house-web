window.onload = function (){
    let tr = document.getElementsByClassName("pure-table-odd");
    // 调色 将表格中调成斑纹的样子
    for(let i = 0; i < tr.length; i++){
        if( i % 2 === 0 ){
            for(let j = 0; j < tr[i].children.length; j++){
                tr[i].children[j].style.backgroundColor = "#ffffff";
            }
        }
    }

    $('.choose-li').click(function (){
        $('.choose-li').attr('style','');
        $(this).css('background-color','#f0f0f0');
    })
}