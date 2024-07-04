package com.starbucks.coffee_order.service;

import com.starbucks.coffee_order.pojo.*;

import java.util.List;


public interface OrderService {
    Coffee findByName(String name);

    Order createOrder(OrderRequest orderRequest);

    List<OrderReturn> findByUserId(Integer id);

    void setOrderCompleted(Integer orderId);

    void setOrderCancelled(Integer orderId);

    Store findStore(String storeName);
}
