package com.starbucks.coffee_order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Token {
    private String token;

    private Integer root;


}
