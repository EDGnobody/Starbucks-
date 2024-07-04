package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.*;
import com.starbucks.coffee_order.service.OrderService;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if(orderservice.findStore(orderRequest.getStoreName())==null)
        {
            return Result.error(314,"店铺不存在",null);
        }
        try {
            order = orderservice.createOrder(orderRequest);
        } catch (Exception e) {
            return Result.error(313, e.getMessage(),null);
        }
        return Result.success(order);
    }

    @GetMapping("/get_by_user_id")
    public Result<List<OrderReturn>> getByUserId(){
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        List<OrderReturn> orderReturnList = orderservice.findByUserId(id);
        return Result.success(orderReturnList);
    }

    @PostMapping("/update_status")
    public Result<String> updateStatus(Integer orderId,Integer status){
        if(status==1){
            orderservice.setOrderCompleted(orderId);
        }
        else if(status==2){
            orderservice.setOrderCancelled(orderId);
        }
        return Result.success();
    }
}


