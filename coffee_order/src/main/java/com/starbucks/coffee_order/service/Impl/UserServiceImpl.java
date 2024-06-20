package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.UserMapper;
import com.starbucks.coffee_order.service.UserService;
import com.starbucks.coffee_order.utils.Md5Util;
import com.starbucks.coffee_order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public User findByUsername(String username) {
        User u = usermapper.findByUsername(username);
        return u;
    }

    @Override
    public void register(String username, String password) {

        //加密
        String Md5String = Md5Util.getMD5String(password);
        //添加到数据库
        usermapper.add(username,Md5String);

    }
}
