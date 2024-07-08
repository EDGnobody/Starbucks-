package com.starbucks.coffee_order.Config;

import com.starbucks.coffee_order.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor logininterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logininterceptor).excludePathPatterns("/user/register",
                "/user/login","/store/get_coffee_list","/store/{province}","/coffee/get_coffee_list",
        "/coffee/{category}","/file/download/**","/user/send_verification_code");
    }
}
