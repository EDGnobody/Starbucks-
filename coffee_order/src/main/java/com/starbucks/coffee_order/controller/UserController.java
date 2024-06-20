package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.Result;
import com.starbucks.coffee_order.service.UserService;
import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.utils.JwtUtil;
import com.starbucks.coffee_order.utils.Md5Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Valid
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        //查找用户
        User u = userservice.findByUsername(username);
        if(null == u)
        {
            userservice.register(username,password);
            return Result.success();
        }
        else
        {
            return Result.error(301,"该用户名已被注册");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        //首先查找用户
        User u = userservice.findByUsername(username);
        if(u == null)
        {
            return Result.error(302,"用户名未注册");
        }
        else
        {
            if(Md5Util.getMD5String(password).equals(u.getPassword()))
            {
                Map<String,Object> claims = new HashMap<>();
                claims.put("id",u.getId());
                claims.put("username",u.getUsername());
                String tokens = JwtUtil.genToken(claims);
                return Result.success(tokens);
            }
            else
            {
                return Result.error(303,"密码错误");
            }
        }
    }
}
