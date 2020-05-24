$("#mynavbar>ul>li>a").click(function(){
    $("#mynavbar>ul>li>a").removeClass("active");

})

// 开启和隐藏modal
$('.uploadPhoto').click(function(){
    //隐藏modal
    $('#uploadPhoto').modal('hide');
});

//开启modal
$('.smodal').click(function(){
    $('#uploadPhoto').modal('show');
})

$("#mynavbar>ul>li>a").click(function(){
    $("#mynavbar>ul>li>a").removeClass("active");
    //   $(this).addClass("active");

})

// 开启和隐藏modal
$('.uploadPhoto').click(function(){
    //隐藏modal
    $('#uploadPhoto').modal('hide');
});

//开启modal
$('.smodal').click(function(){
    $('#uploadPhoto').modal('show');
})


//搜索的下拉框
$(document).ready(function(){
    $("#searchInput").keyup(function(){
        var searchInput = $("#searchInput").val();       //获取搜索框输入的值

        $.get("queryPhotoByHeadline/"+ searchInput, function(data){//{'searchInput':searchInput},
            var result=data.extend.photoList;//参数：发送的url；传入的数据；请求成功后的调用函数（data即是试图函数返回的json格式数据）详情
            var size = data.extend.size;
            for (var i = size - 1; i >= 0; i--) {
                $('#search-result').append(result[i].headline+'<br/>')      //加入到search-result部分显示
            };
        })
    });
    $('#searchInput').keydown(function(){
        $('#search-result').empty();
    })
    $('#searchInput').blur(function(){
        $('#search-result').empty();
    })
});

$("#search").click(function(){
    var searchInput = $("#searchInput").val();       //获取搜索框输入的值
    window.open("searchPhotoPage?headline=" + searchInput);
})


// ("#search").click(function(){
//     var searchInput = $("#searchInput").val();       //获取搜索框输入的值
//     $.ajax({
//         url:"queryPhotoByHeadline/"+searchInput,
//         data:{"head":},
//         type:"POST",
//         success:function(result){
//             if (result.code == 100) {//后台请求成功
//
//                 // alert(JSON.stringify(result));
//                 var albums = result.extend.photoList;
//                 var size = result.extend.size;
//                 var html = '';
//                 for (var i = 0; i < size; i++) {
//                     var album = albums[i];
//                     html += '<div class="col-md-3 AlbumId"  onclick="into(\''+album.id+'\')">';
//                     html += '<div class="img">';
//                     html += '</div>';
//                     html += '<p class="photoName">'+album.name+'</p>';
//                     html += '<div class="eachPhotoButton"  style="margin-top:5px;" onclick="stopPropagation()">';
//                     html += '<button  class="btn btn-xs btn-warning revise" id="'+album.id+'" onclick = "editAlbum(\''+album.id+'\')" >编辑</button>';
//                     html += '<button  class="btn btn-xs btn-warning delete" style="float: right;" onclick="deleteAlbum(\''+album.id+'\')">删除</button>';
//                     html += '</div>';
//                     html += '</div>';
//                 }
//                 $("#album_div").html(html);
//             } else {//后台请求失败
//                 alert(result.msg);//弹出错误信息
//             }
//         }
//     })
//
// })
