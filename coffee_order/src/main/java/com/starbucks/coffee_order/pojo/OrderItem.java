package com.starbucks.coffee_order.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItem {

    @NotNull
    private Integer id;

    @NotNull
    private Integer orderId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer coffeeId;

    @NotNull
    private String coffeeName;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;

}
