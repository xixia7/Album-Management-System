/**
 * @Author: ；王渭菌
 * @Date: 2019/4/4
 * @Description: 注册模态框
 */

// 开启和隐藏modal
$('.register').click(function(){
    //隐藏modal
    $('#register').modal('hide');
});

//开启modal
$('.smodal').click(function(){
    $('#register').modal('show');

})


/**
 * @Author: ；吕庆龙 王渭菌
 * @Date: 2019/4/8
 * @Description: 登录注册的ajax交互和校验
 */

//点击确定触发注册函数
function register() {
    var register_username = $("#register_username").val();
    // 表单元素的value取值不会为null, 取值是空字符串
    if ( register_username == "" ) {
        layer.msg("用户登录账号不能为空，请重新输入", {time:2000, icon:5, shift:6}, function(){

        });
        return;
    }

    var register_password = $("#register_password").val();
    if ( register_password == "" ) {
        layer.msg("用户登录密码不能为空，请重新输入", {time:2000, icon:5, shift:6}, function(){

        });
        return;
    }

    var register_gender=$('input:radio[type="radio"]:checked').val();


    // 使用AJAX提交数据
    var loadingIndex = null;
    $.ajax({
        type : "POST",
        url  : "doRegister",
        data : {
            "userName" : register_username,
            "passWord" : register_password,
            "gender"   : register_gender
        },
        //防止网络不好时，页面什么反应都没有
        beforeSend : function(){
            loadingIndex = layer.msg('处理中', {icon: 16});
        },
        success : function(result) {
            //处理成功了，就要把‘处理中’    这个弹层给关掉
            layer.close(loadingIndex);
            if (result.code == 100) {
                layer.msg("注册成功，可直接登陆~", {time:2000, icon:6, shift:5}, function(){

                });
            } else {
                layer.msg("注册失败，请重新注册~", {time:2000, icon:5, shift:6}, function(){

                });
            }
        }
    });
}


//点击登录触发函数
function dologin() {
    // 非空校验
    var username = $("#username").val();
    // 表单元素的value取值不会为null, 取值是空字符串
    if ( username == "" ) {
        layer.msg("用户登录账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){

        });
        return;
    }

    var password = $("#password").val();
    if ( password == "" ) {
        layer.msg("用户登录密码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){

        });
        return;
    }


    // 使用AJAX提交数据
    var loadingIndex = null;
    $.ajax({
        type : "POST",
        url  : "doLogin",
        data : {
            "userName" : username,
            "passWord" : password
        },
        //防止网络不好时，页面什么反应都没有
        beforeSend : function(){
            loadingIndex = layer.msg('处理中~', {icon: 16});
        },
        success : function(result) {
            //处理成功了，就要把‘处理中’  这个弹层给关掉
            layer.close(loadingIndex);
            if (result.code == 100) {
                window.location.href = "homepage";  //这里应该直接跳转homepage页面，然后由homepage页面给后端发送ajax
                //alert(result.extend.user.userName)  前端获取数据的方法
            } else {
                layer.msg("用户登录账号或密码不正确，请重新输入！", {time:2000, icon:5, shift:6}, function(){

                });
            }
        }
    });
}
