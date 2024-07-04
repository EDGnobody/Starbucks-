package com.starbucks.coffee_order.mapper;

import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.pojo.UserUpdate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    //根据用户名寻找用户
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    //向数据库中添加用户
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(String username, String password);

    @Update("update user set nickname=#{nickname},update_time=now(),username=#{username} where id=#{id}")
    void update(UserUpdate userupdate);

    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{newPwd},update_time=now() where id =#{id}")
    void updatePassword(String newPwd,Integer id);
}
