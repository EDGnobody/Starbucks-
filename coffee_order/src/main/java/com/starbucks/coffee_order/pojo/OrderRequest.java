package com.starbucks.coffee_order.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotEmpty
    private List<OrderItem> items;

    @NotEmpty
    private String storeName;
}
