var btn2_b=document.getElementById("confirm");
var div2_b=document.getElementById("wrapper");
var close1_b=document.getElementById("close-button_b");
var close2_b=document.getElementById("cancle_b");
var btn3_b = document.getElementById("confirm_b");


// close1_b.onclick=function close1(){
//     div2_b.style.display="none";
// }
//点击关闭按钮的时候关闭页面
$("#close-button_b").click(function(){
    div2_b.style.display="none";
})


// close2_b.onclick=function close2(){
//     div2_b.style.display="none";
// }
//点击取消按钮的时候关闭页面
$("#cancle_b").click(function(){
    div2_b.style.display="none";
})

// btn3_b.onclick=function close3() {
//     div2_b.style.display="none";
// }
//点击确认按钮的时候执行并关闭页面
$("#confirm_b").click(function(){
    div2_b.style.display="none";
})

// ryj
//点击确认按钮执行ajax
$("#confirm").click(function () {


// btn2_b.onclick=function add_album(){
    //获取创建的相册名的id
    var albumname = $("#albumname").val();
    var b_album = $("#b_album").val();
    $.ajax({
        url:"createAlbum",
        data:{
            "name":albumname,
            "discription":b_album
        },
        type:"POST",
        success:function(result){
            if (result.code == 100){
                location.reload();
            }else{
                alert("创建相册失败");
            }

        }

    })

})