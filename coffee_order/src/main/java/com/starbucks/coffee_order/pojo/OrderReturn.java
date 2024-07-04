package com.starbucks.coffee_order.pojo;

import lombok.Data;

import java.util.List;

@Data
public class OrderReturn {

    private Order order;

    private List<OrderItem> orderItems;
}
