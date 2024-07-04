package com.starbucks.coffee_order.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserUpdate {

    Integer id;

    private String username;//用户名

    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//昵称
}
