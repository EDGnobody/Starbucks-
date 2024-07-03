package com.starbucks.coffee_order.pojo;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private List<OrderItem> items;
}
