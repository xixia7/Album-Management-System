var albumdelete = document.getElementsByClassName("delete")[0];
var closeButton1=document.getElementById("close-button1");
var confirm1=document.getElementById("confirm1");
var cancle1=document.getElementById("cancle1");
var home = document.getElementById("home");

var AlbumId;
//获取删除的相册的id
function  deleteAlbum(id) {
    home.style.display = "block";
    AlbumId=id;
}

// $("#close-button1").click(function () {
// //     home.style.display="none";
// // })
//点击关闭按钮关闭页面
closeButton1.onclick = function  close() {
    home.style.display="none";
}



// $("#cancle1").click(function () {
//     home.style.display="none";
// })
//点击取消按钮关闭页面
cancle1.onclick = function cancle(){
    home.style.display="none";
}
//点击确认按钮的时候触发ajax
$("#confirm1").click(function() {
    $.ajax({
        //获取删除的照片的路径
        url:"deleteAlbumByExample",
        data:{
            "id":AlbumId
        },
        type:"POST",
        success:function(result){
            if (result.code==100){
                location.reload();
            }
            else {
                alert("删除失败");
            }
        }
    })
})


