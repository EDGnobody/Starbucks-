package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.*;
import com.starbucks.coffee_order.service.OrderService;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @PostMapping("/add")
    public Result<Order> add(@RequestBody OrderRequest orderRequest){
        Order order = null;
        try {
            order = orderservice.createOrder(orderRequest.getItems());
        } catch (Exception e) {
            return Result.error(313, e.getMessage(),null);
        }
        return Result.success(order);
    }
}
