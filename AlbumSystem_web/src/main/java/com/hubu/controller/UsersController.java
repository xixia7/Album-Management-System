package com.hubu.controller;

import com.hubu.pojo.Msg;
import com.hubu.pojo.Users;
import com.hubu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: 用户管理控制器
 * @version: 1.0
 */
@ResponseBody
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;


    /**
     * 功能描述: 用户登录
     * @param: user 前端传来的用户数据
     * @return: 封装的ajax类
     * @author: 吕庆龙
     * @date: 2019/4/5
     */

    @RequestMapping("/doLogin")
    public Msg checkUserLogin(Users user,HttpServletRequest request) {
        Msg result = new Msg();
//     (1) 获取表单数据
//         （1-1) HttpServletRequest
//         （1-2) 在方法参数列表中增加表单对应的参数，
//         （1-3) 就是将表单数据封装为实体类对象,这里用的是此方法。表单元素的name
//               属性和User类的属性必须相同
        Users loginUser = usersService.checkUserLoginService(user);
        HttpSession session = request.getSession();
        if (loginUser != null) {
            //将此用户的所有信息封装成Users对象，方便后续所有操作
            session.setAttribute("user", loginUser);
            return Msg.success();
        } else {
            // 登陆失败，跳转回到登陆页面，提示错误信息(前后交互的时候再做)
            String errorMsg = "登陆账号或密码不正确，请重新输入";
            session.setAttribute("errorMsg", errorMsg);
            // springmvc默认使用的是请求转发
            return Msg.fail();
        }
    }


    /**
     * 功能描述: 用户注册
     * @param: user 前端传来的用户数据
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/5
     */
    @RequestMapping("/doRegister")
    public Msg userRegister(Users user){
        int index = usersService.userRegister(user);
        if(index > 0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


}
