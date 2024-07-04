package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.Result;
import com.starbucks.coffee_order.pojo.Token;
import com.starbucks.coffee_order.pojo.UserUpdate;
import com.starbucks.coffee_order.service.UserService;
import com.starbucks.coffee_order.pojo.User;
import com.starbucks.coffee_order.utils.JwtUtil;
import com.starbucks.coffee_order.utils.Md5Util;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Valid
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/register")
    public Result<String> register(@Pattern(regexp = "^\\S{5,16}$") String username,
                                   @Pattern(regexp = "^\\S{5,16}$") String password){

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
    public Result<Token> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        //首先查找用户
        User u = userservice.findByUsername(username);
        if(u == null)
        {
            return Result.error(302,"用户名未注册",null);
        }
        else
        {
            if(Md5Util.getMD5String(password).equals(u.getPassword()))
            {
                Map<String,Object> claims = new HashMap<>();
                claims.put("id",u.getId());
                claims.put("username",u.getUsername());
                String tokens = JwtUtil.getToken(claims);
                Token token = new Token(tokens,u.getRoot());
                return Result.success(token);
            }
            else
            {
                return Result.error(303,"密码错误",null);
            }
        }
    }

    @GetMapping("/userinfo")
    public Result<User> userinfo(@RequestHeader(name = "Authorization") String token){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userservice.findByUsername(username);
        return Result.success(user);
    }


    @PutMapping("/update")
    public Result<String> update(@Validated UserUpdate userupdate){
        try {
            userservice.update(userupdate);
        } catch (Exception e) {
            Result.error(330,e.getMessage());
        }
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestParam @URL String AvatarUrl){
        userservice.updateAvatar(AvatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result<String> updatePassword(@RequestBody Map<String,String> m){
        String oldPwd = m.get("old_pwd");
        String newPwd = m.get("new_pwd");
        String rePwd = m.get("re_pwd");
        Map<String,Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error(304,"密码不能为空");
        }
        User Loginuser = userservice.findByUsername(username);
        if(!Loginuser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error(307,"旧密码错误");
        }
        if(oldPwd.equals(newPwd)){
            return Result.error(305,"新密码不能与旧密码相同");
        }
        if(!newPwd.equals(rePwd)){
            return Result.error(306,"两次输入不一致");
        }
        String Md5 = Md5Util.getMD5String(newPwd);
        userservice.updatePassword(Md5);
        return Result.success();
    }
}
