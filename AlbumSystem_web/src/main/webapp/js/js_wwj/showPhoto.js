// 开启和隐藏modal

//隐藏modal
$('.upload').click(function(){
    $('#upload').modal('hide');
});
        
//开启modal
$('.upload').click(function(){
    $('#upload').modal('show');
})




//隐藏modal
$('.delete').click(function(){
    $('.alert_delete').modal('hide');
})
//开启modal
$('.delete').click(function(){
    $('.alert_delete').modal('show');
})


  //点击相册时显示相片
function search_showphoto(albumId){
     $.ajax({
    	url:"selectAllPhoto/" + albumId, //，每个相册对应的查询相片的路径
    	type:"get",
    	success:function(result){
            // alert(JSON.stringify(result));
    		var photos = result.extend.Allphotos;//照片的集合对象名称;
            var size = result.extend.size;
			var html = '';
    		for (var i = 0; i < size; i++) {
    			var photo = photos[i];
    			//动态显示所有的照片的html
				html += '<div class="col-md-3">';
				html +=		'<div class="img">';
				html +=     '<img src ="'+photo.path+'" style= " width: 135px;height :140px;"/>';//'+photo.path+'
				html +=		'</div>';
				html +=		'<p class="photoName">'+photo.headline+'</p>';
				html +=		'<div class="eachPhotoButton" style="margin-top:5px;">';
				html +=         '<button  class="btn btn-xs btn-warning smodal check" onclick = "photo_check(\''+photo.id+'\')">查看</button>';
				html +=			'<button  class="btn btn-xs btn-warning smodal delete" onclick = "photo_delete(\''+photo.id+'\')" style="float: right;">删除</button>';
				html +=		'</div>';
				html += '</div>';
				
    		}
			$("#photo_div").html(html);
    	}
    })
}
$(function () {
    search_showphoto(getQueryString("id"))
})
//获取url路径的方法
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


function upload() {
    var photoName = $("#photoName").val();
    var photoExplain = $("#photoExplain").val();
    // var fileObj = document.getElementById("fileUpload").files[0];  // 获取文件对象

    // if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
    //     alert("请选择图片");
    //     return;
    // }
    var selectFile = new FormData($('#selectFile')[0]);

    selectFile.append("photoName", photoName);
    selectFile.append("photoExplain", photoExplain)
    // formFile.append("file", fileObj); //加入文件对象
    selectFile.append("albumId",getQueryString("id"))//getQueryString("id")
    console.log(selectFile);
    console.log(photoName);
    console.log(photoExplain);
    console.log(getQueryString("id"));

    $.ajax({
        url: "photoUpload",
        data: selectFile,//JSON.stringify(selectFile)
        type: "POST",
        processData: false,
        cache: false,
        async: true,
        contentType: false,
        //contentType : 'application/json',
        //只返回一个字符串，dataType要设置为“html”.
        dataType:'json',//@刘钦华改的，设定返回类型
        beforeSend:function(){
            alert("准备传输信息！");
        },
        error: function (data) {//@刘钦华， 这个函数加入了data
            alert("上传失败！");
        },
        success: function (data) {
            location.reload();
        }
    })
}


function  photo_delete(id) {
    PhotoId=id;
    // alert(PhotoId);

    $.ajax({
        url: "deletePhotoById",
        data: {
            "id": PhotoId
        },
        type: "POST",
        success: function (result) {
            if (result.code == 100) {
                location.reload();
            }
            else {
                alert("删除失败");
            }
        }
    })
}



//点击查看图片
function photo_check(id) {
    // var check = document.getElementById("check");
    // alert(check);
    // check.style.display="block";
    $('#check').modal('show');
    PhotoId=id;

    var path = document.getElementById("photo_src");

    $.ajax({
        url:"selectPhotoById",
        data:{
            "id":PhotoId
        },
        type:"POST",
        //dataType:"TEXT",
        success:function(result){
            if (result.code == 100)
            {   $("#photo_image").attr("src",result.extend.photo.path);
                // $("#photo_image").html('<img id="photo_src" style="width:100%" src="'+result.extend.photo.path+'">');
                $("#photo_name").text(result.extend.photo.headline);
                $("#photo_size").text(result.extend.photo.photoSize);
                $("#photo_description").text(result.extend.photo.discription);
                $("#photo_createtime").text(result.extend.photo.createTime);
                $("#photo_modifytime").text(result.extend.photo.updateTime);

            }
            else{

            }
        }
    })
}