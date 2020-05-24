function searchPhotoPage(albumHeadline){
    // var albumHeadlinecode = encodeURI(albumHeadline);//对该中文参数进行编码

    $.ajax({
        url:"queryPhotoByHeadline/" + albumHeadline, //，每个相册对应的查询相片的路径
        type:"get",
        success:function(result){
            if (result.code == 100) {//后台请求成功
                // alert(JSON.stringify(result));
                var photos = result.extend.photoList;
                var size = result.extend.size;
                var html = '';
                for (var i = 0; i < size; i++) {
                    var photo = photos[i];
                    html += '<div class="col-md-3">';
                    html +=		'<div class="img">';
                    html +=     '<img src ="'+photo.path+'" style= " width: 135px;height :140px;"/>';
                    html +=		'</div>';
                    html +=		'<p class="photoName">'+photo.headline+'</p>';
                    html +=		'<div class="eachPhotoButton" style="margin-top:5px;">';
                    // html +=         '<button  class="btn btn-xs btn-warning smodal check" onclick = "photo_check(\''+photo.id+'\')">查看</button>';
                    html +=		'</div>';
                    html += '</div>';
                }
                $("#photo_div").html(html);
            } else {//后台请求失败
                alert(result.msg);//弹出错误信息
            }
        }
    })
}
$(function () {
    searchPhotoPage(getQueryString("headline"))
})
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var reg_rewrite = new RegExp("(^|/)" + name + "/([^/]*)(/|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    var q = window.location.pathname.substr(1).match(reg_rewrite);
    if(r != null){
        return unescape(r[2]);
    }else if(q != null){
        return unescape(q[2]);
    }else{
        return null;
    }
}