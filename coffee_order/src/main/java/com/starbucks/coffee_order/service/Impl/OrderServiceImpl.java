package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.OrderMapper;
import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.pojo.Order;
import com.starbucks.coffee_order.pojo.OrderItem;
import com.starbucks.coffee_order.service.OrderService;
import com.starbucks.coffee_order.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Order createOrder(List<OrderItem> orderList) {
        Order order = new Order();
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        order.setUserId(userId);
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
        System.out.println(orderId);
        ordermapper.changeTotalPrice(orderId,totalPrice);
        System.out.println(orderId);
        order.setTotalPrice(totalPrice);
        return order;
    }

}
