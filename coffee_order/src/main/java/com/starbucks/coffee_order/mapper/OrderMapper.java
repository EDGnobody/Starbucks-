package com.starbucks.coffee_order.mapper;

import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.pojo.Order;
import com.starbucks.coffee_order.pojo.OrderItem;
import com.starbucks.coffee_order.pojo.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from coffee where name=#{name}")
    Coffee findByName(String name);

    @Insert("insert into coffee_details(user_id, coffee_id, order_id, coffee_name, quantity, price) " +
            "values (#{userId},#{coffeeId},#{orderId},#{coffeeName},#{quantity},#{price})")
    void addOrderItem(OrderItem orderItem);

    @Insert("insert into `order`(user_id, store_name,order_date) values (#{userId},#{storeName},#{orderDate})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void createOrder(Order order);

    @Update("update `order` set total_price=#{totalPrice} where id =#{orderId}")
    void changeTotalPrice(Integer orderId, int totalPrice);

    @Select("select * from `order` where user_id=#{userId}")
    List<Order> getByUserId(Integer userId);

    @Select("select * from coffee_details where order_id=#{orderId}")
    List<OrderItem> findByOrderId(Integer orderId);

    @Update("update `order` set status = 1 where id = #{orderId}")
    void setOrderCompleted(Integer orderId);

    @Update("update `order` set status = 2 where id = #{orderId}")
    void setOrderCancelled(Integer orderId);

    @Select("select * from store where name=#{storeName}")
    Store findStore(String storeName);
}
