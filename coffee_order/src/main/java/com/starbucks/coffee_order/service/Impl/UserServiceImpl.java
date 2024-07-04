package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.UserMapper;
import com.starbucks.coffee_order.pojo.UserUpdate;
import com.starbucks.coffee_order.service.UserService;
import com.starbucks.coffee_order.utils.Md5Util;
import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public void update(UserUpdate userupdate){
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        User user = usermapper.findById(id);
        if(user == null){
            throw new RuntimeException("用户名不存在");
        }
        if(userupdate.getUsername()==null)
        {
            userupdate.setUsername(user.getUsername());
        }
        if(userupdate.getNickname()==null)
        {
            userupdate.setNickname(user.getNickname());
        }
        usermapper.update(userupdate);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> m = ThreadLocalUtil.get();
        Integer id = (Integer) m.get("id");
        usermapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePassword(String newPwd) {
        Map<String,Object> m = ThreadLocalUtil.get();
        Integer id = (Integer) m.get("id");
        usermapper.updatePassword(newPwd,id);
    }
}
