package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.OrderMapper;
import com.starbucks.coffee_order.pojo.*;
import com.starbucks.coffee_order.service.OrderService;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper ordermapper;

    @Override
    public Coffee findByName(String name) {
        return ordermapper.findByName(name);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        List<OrderItem> orderList = orderRequest.getItems();
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        order.setUserId(userId);
        order.setStoreName(orderRequest.getStoreName());
        order.setOrderDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        ordermapper.createOrder(order);
        Integer orderId = order.getId();
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            orderItem.setOrderId(orderId);
            orderItem.setUserId(userId);
            String coffeeName = orderItem.getCoffeeName();
            Coffee coffee = ordermapper.findByName(coffeeName);
            if (coffee == null) {
                throw new RuntimeException(coffeeName+"咖啡不存在");
            }
            Integer price = coffee.getPrice();
            Integer quantity = orderItem.getQuantity();
            Integer coffeeId = coffee.getId();
            orderItem.setPrice(price);
            orderItem.setCoffeeId(coffeeId);
            ordermapper.addOrderItem(orderItem);
            totalPrice += price * quantity;
        }
        ordermapper.changeTotalPrice(orderId,totalPrice);
        order.setTotalPrice(totalPrice);
        return order;
    }

    @Override
    public List<OrderReturn> findByUserId(Integer userId) {
        List<Order> order_list = ordermapper.getByUserId(userId);
        List<OrderReturn> orderReturnList = new ArrayList<>();
        for (Order order : order_list) {
            System.out.println(order.toString());
            OrderReturn orderReturn = new OrderReturn();
            orderReturn.setOrder(order);
            List<OrderItem> orderItems = ordermapper.findByOrderId(order.getId());
            orderReturn.setOrderItems(orderItems);
            orderReturnList.add(orderReturn);
        }
        return orderReturnList;
    }

    @Override
    public void setOrderCompleted(Integer orderId) {
        ordermapper.setOrderCompleted(orderId);
    }

    @Override
    public void setOrderCancelled(Integer orderId) {
        ordermapper.setOrderCancelled(orderId);
    }

    @Override
    public Store findStore(String storeName) {
        return ordermapper.findStore(storeName);
    }

}
