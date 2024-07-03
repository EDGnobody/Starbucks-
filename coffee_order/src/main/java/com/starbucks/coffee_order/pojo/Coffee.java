package com.starbucks.coffee_order.pojo;
//实体类


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Coffee {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    private String description = "";

    @NotNull
    private Integer price;

    private String category = "coffee";

    private String picture;

    private boolean available = true;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}


