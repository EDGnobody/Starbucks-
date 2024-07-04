package com.starbucks.coffee_order.mapper;


import com.starbucks.coffee_order.pojo.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Select("SELECT * FROM store ORDER BY province")
    List<Store> findAllOrderedByProvince();

    @Select("SELECT * FROM store WHERE province = #{province}")
    List<Store> findByProvince(String province);

    @Insert("insert into store(name, location, province, phone, latitude, longitude) " +
            "values(#{name},#{location},#{province},#{phone},#{latitude},#{longitude}) ")
    void add(Store store);
}



