package com.starbucks.coffee_order.pojo;
//实体类


import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String category = "咖啡";

    private String picture ;

    private boolean available = true;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;

}


