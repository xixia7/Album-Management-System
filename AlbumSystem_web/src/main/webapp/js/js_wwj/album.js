var AlbumId = null;
//保存相册id到session的ajax
function into(id) {

  window.open("showPhoto?id=" + id);

}

//阻止冒泡
function stopPropagation() {
    event.stopPropagation();
}


//获取用户相册的属性,动态显示所有相册
$(function(){
    //获取显示的相册的路径
    $.ajax({
        url:"showAllAlbum",
        type:"get",
        success:function(result){
            //后台请求成功
            if (result.code == 100) {
               // alert(JSON.stringify(result));
                var albums = result.extend.selAllAlbum;
                var size = result.extend.albumSize;
                var html = '';
                for (var i = 0; i < size; i++) {
                    var album = albums[i];
                    //动态创建相册的html
                    html += '<div class="col-md-3 AlbumId"  onclick="into(\''+album.id+'\')">';
                    html += '<div class="img">';
                    html +='<div  class="explain">';
                    html +='<p>'+album.discription+'</p>';
                    html +='</div>';
                    html += '</div>';
                    html += '<p class="photoName">'+album.name+'</p>';
                    html += '<div class="eachPhotoButton"  style="margin-top:5px;" onclick="stopPropagation()">';
                    html += '<button  class="btn btn-xs btn-warning revise" id="'+album.id+'" onclick = "editAlbum(\''+album.id+'\')" >编辑</button>';
                    html += '<button  class="btn btn-xs btn-warning delete" style="float: right;" onclick="deleteAlbum(\''+album.id+'\')">删除</button>';
                    html += '</div>';
                    html += '</div>';
                }
                $("#album_div").html(html);
                //后台请求失败
            } else {
                //弹出错误信息
                alert(result.msg);
            }
        }
    })
});

//
// function editAlbum(id) {
//     revBackground.style.display="block";
//     AlbumId = id;
//     alert(AlbumId);
//     return AlbumId;
// }

//打开编辑相册弹窗
var AlbumId;
function  editAlbum(id) {
    revBackground.style.display = "block";
    AlbumId=id;
}
//编辑相册弹窗点击确定
$("#rev-confirm").click(function() {
    var name = $("#rev-albumname").val();
    var discrip = $("#rev-album-des").val();

    $.ajax({
        url:"editAlbumInform",
        data:{
            "id":AlbumId,
            "name" : name,
            "discription" : discrip
        },
        type:"POST",
        success:function(result) {
            alert
            location.reload();
        },
        error:function() {

        }
    })
})

function deleteAlbum() {
    home.style.display="block";
}

