package com.starbucks.coffee_order.pojo;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
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

    private LocalDateTime orderDate;

    @JsonValue
    private OrderStatus status = OrderStatus.pending;

}
