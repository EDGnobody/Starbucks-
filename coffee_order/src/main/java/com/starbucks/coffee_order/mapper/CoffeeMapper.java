package com.starbucks.coffee_order.mapper;

import com.starbucks.coffee_order.pojo.Coffee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CoffeeMapper {

    @Select("select * from coffee where name=#{name}")
    Coffee findByName(String name);

    @Select("select * from coffee where id=#{id}")
    Coffee findById(int id);

    @Insert("insert into coffee(name,description,price,category,available,picture,create_time,update_time) " +
            "values(#{name},#{description},#{price},#{category},#{available},#{picture},now(),now())")
    void create(Coffee coffee);

    @Update("update coffee set name=#{name},price=#{price},description=#{description},update_time=now() where id=#{id}")
    void update(Coffee coffee);

    @Update("update coffee set category=#{category} where id=#{id}")
    void updateCategory(String category,Integer id);

    @Select("select * from coffee order by category")
    List<Coffee> get_category_list();

    @Select("select * from coffee where category=#{category}")
    List<Coffee> findByCategory(String category);
}
