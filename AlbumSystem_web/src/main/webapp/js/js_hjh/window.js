// var btn_a=document.getElementById("open");
var btn_a=document.getElementById("open");

var div_a=document.getElementById("background");
var close1_a=document.getElementById("close-button");
var close2_a=document.getElementById("cancle");

//     btn_a.onclick = function show() { //了解这种写法为什么会报错
//         div_a.style.display = "block";
//     }
$("#open").click(function(){
    div_a.style.display="block";
})

// close1_a.onclick = function close1() {
//     div_a.style.display = "none";
// }
//点击关闭按钮关闭页面
$("#close-button").click(function() {
    div_a.style.display = "none";
})

// close2_a.onclick = function close2() {
//     div_a.style.display = "none";
// }
//点击取消按钮关闭页面
$("#cancle").click(function () {
    div_a.style.display = "none";
})