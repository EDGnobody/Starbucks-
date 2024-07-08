package com.starbucks.coffee_order.service;

import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.pojo.UserUpdate;
import org.apache.ibatis.annotations.Select;

public interface UserService {

    //根据用户名查询用户
    User findByUsername(String username);

    //邮箱
    User findByEmail(String email);

    //注册
    void register(String username, String password);

    void update(UserUpdate userupdate);

    void updateAvatar(String avatarUrl);

    void updatePassword(String newPwd);

    void registerAdmin(String username, String password);

    void saveUser(User user);
}
