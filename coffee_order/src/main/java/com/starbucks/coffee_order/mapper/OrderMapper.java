package com.starbucks.coffee_order.mapper;

import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.pojo.Order;
import com.starbucks.coffee_order.pojo.OrderItem;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Select("select * from coffee where name=#{name}")
    Coffee findByName(String name);

    @Insert("insert into coffee_details(user_id, coffee_id, order_id, coffee_name, quantity, price) " +
            "values (#{userId},#{coffeeId},#{orderId},#{coffeeName},#{quantity},#{price})")
    void addOrderItem(OrderItem orderItem);

    @Insert("insert into `order`(user_id, order_date) values (#{userId},now())")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void createOrder(Order order);

    @Update("update `order` set total_price=#{totalPrice} where id =#{orderId}")
    void changeTotalPrice(Integer orderId, int totalPrice);
}
