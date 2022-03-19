window.onload = function (){
    let btnNext = document.getElementsByClassName("btn-next")[0];
    let btnBack = document.getElementsByClassName("btn-back")[0];

    // btnNext.onclick = function (){
    //     window.location.href="verification.jsp";
    //     // console.log("世一恋！");
    // }

    btnBack.onclick = function (){
        window.history.go(-1);
    }
}