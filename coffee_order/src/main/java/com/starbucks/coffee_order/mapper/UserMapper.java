package com.starbucks.coffee_order.mapper;

import com.starbucks.coffee_order.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //根据用户名寻找用户
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    //向数据库中添加用户
    @Select("insert into user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(String username, String password);
}
