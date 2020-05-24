package com.hubu.service;

import com.hubu.pojo.Users;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/1
 * @Description: com.hubu.service
 * @version: 1.0
 */
public interface UsersService {


    Users checkUserLoginService(Users user);


    int userRegister(Users user);
}
