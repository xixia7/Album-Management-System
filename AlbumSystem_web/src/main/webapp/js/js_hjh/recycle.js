//遍历回收站html执行ajax
 $(function(){
     $.ajax({
         //获取放入回收站照片的路径
         url:'queryRecyclePhoto',
         data:null,
         type:'get',
         success:function(result){
             //后台请求成功
             if (result.code == 100) {
                 var recy_photos = result.extend.allPhoto;
                 var size = result.extend.size;
                 var html = '';
                 //循环遍历回收站照片的html
                 for (var i = 0; i < size; i++) {
                     var recy_photo = recy_photos[i];
                     html += '<div class="col-md-3">';
                     html += '<div class="img">';
                     html += '<img src = "'+recy_photo.path+'"'+'style = "width:135px;height:140px;"/>'
                     html += '</div>';
                     html += '<div class="row" style="width:98%;margin: 2px auto;">';
                     html += '<div class="Album_name">'+recy_photo.headline+'</div>';
                     html += '<button  class="btn btn-xs btn-warning smodal delete" onclick = "resavephoto(\''+recy_photo.id+'\')" style="float: right;">恢复</button>';
                     html += '</div>';
                     html += '</div>';
                 }
                 $("#recycle_div").html(html);
             } else {//后台请求失败
                 alert(result.msg);//弹出错误信息
             }

         }
     })
  });

 var r_photoID;
 function  resavephoto(id) {
     r_photoID=id;
     $.ajax({
         url:"restoreRecyclePhoto",
         data:{
             "id":r_photoID
         },
         type:"POST",
         success:function(result) {
             alert("恢复成功")
             location.reload();
         },

     })
 }
 //编辑相册弹窗点击确定
 // $("#btn-xs").click(function() {
 //
 // })


