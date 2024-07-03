package com.starbucks.coffee_order.service;

import com.starbucks.coffee_order.pojo.User;

public interface UserService {

    //根据用户名查询用户
    User findByUsername(String username);

    //注册
    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);

    void updatePassword(String newPwd);
}
