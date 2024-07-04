package com.starbucks.coffee_order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    @NotNull
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer totalPrice;

    @NotNull
    private String storeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime orderDate;

    @NotNull
    private Integer status = 0;

}
