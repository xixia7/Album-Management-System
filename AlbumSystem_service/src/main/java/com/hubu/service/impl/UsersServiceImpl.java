package com.hubu.service.impl;

import com.hubu.mapper.UsersMapper;
import com.hubu.pojo.Users;
import com.hubu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/1
 * @Description: com.hubu.service.impl
 * @version: 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users checkUserLoginService(Users users) {
        Users u=usersMapper.selectUserByExample(users);
        return u;
    }

    @Override
    public int userRegister(Users user) {
        int index = usersMapper.insertUser(user);
        return index;
    }



}
