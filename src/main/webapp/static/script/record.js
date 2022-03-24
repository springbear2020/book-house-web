window.onload = function (){
    let tr = document.getElementsByClassName("pure-table-odd");
    for(let i = 0; i < tr.length; i++){
        if( i % 2 === 0 ){
            for(let j = 0; j < tr[i].children.length; j++){
                tr[i].children[j].style.backgroundColor = "#ffffff";
            }
        }
    }
}