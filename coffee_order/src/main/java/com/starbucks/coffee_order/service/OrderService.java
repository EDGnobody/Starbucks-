package com.starbucks.coffee_order.service;

import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.pojo.Order;
import com.starbucks.coffee_order.pojo.OrderItem;

import java.util.List;


public interface OrderService {
    Coffee findByName(String name);

    Order createOrder(List<OrderItem> orderList);
}
