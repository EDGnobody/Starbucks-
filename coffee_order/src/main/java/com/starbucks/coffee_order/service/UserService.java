package com.starbucks.coffee_order.service;

import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.pojo.UserUpdate;

public interface UserService {

    //根据用户名查询用户
    User findByUsername(String username);

    //注册
    void register(String username, String password);

    void update(UserUpdate userupdate);

    void updateAvatar(String avatarUrl);

    void updatePassword(String newPwd);
}
