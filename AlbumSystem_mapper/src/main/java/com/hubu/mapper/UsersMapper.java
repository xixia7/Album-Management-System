package com.hubu.mapper;

import com.hubu.pojo.Users;

import java.util.List;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/1
 * @Description: com.hubu.mapper
 * @version: 1.0
 */
public interface UsersMapper {

    /**
     * 功能描述: 根据用户名字userName和用户密码passWord校验登录
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/3
     */
    Users selectUserByExample(Users users);


    /**
     * 功能描述:用户注册
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/1
     */
    int insertUser(Users user);
}
