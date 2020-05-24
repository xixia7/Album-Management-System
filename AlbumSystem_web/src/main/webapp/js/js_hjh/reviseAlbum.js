// var open1=document.getElementById("open1");
// var revise = document.getElementsByClassName("revise")[0];
// var revise = document.getElementById("revise");
var revBackground=document.getElementById("rev-background");
var revCloseButton=document.getElementById("rev-close-button");
var revCancle=document.getElementById("rev-cancle");





//点击关闭按钮关闭页面
revCloseButton.onclick=function revClose(){
    revBackground.style.display="none";
}
//点击取消按钮关闭页面
revCancle.onclick=function revCancle(){
    revBackground.style.display="none";
}

// $("#rev-close-button").onclick=function revClose(){
//     revBackground.style.display="none";
// }
//
// $("#rev-cancle").onclick=function revCancle(){
//     revBackground.style.display="none";
// }

