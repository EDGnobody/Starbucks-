package com.starbucks.coffee_order.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Store {

    Integer id;

    @NotNull
    @Size(min=2, max=40,message = "店名长度不合法")
    String name;

    @NotNull
    @Size(min=5, max=200,message = "店面位置长度不合法")
    String location;

    @NotNull
    @Size(min=2, max=10,message = "省份长度不合法")
    String province;

    @NotNull
    @Size(max=12,message = "电话长度不合法")
    String phone;

    @NotNull
    BigDecimal latitude;

    @NotNull
    BigDecimal longitude;

    @NotNull
    Boolean status = true;
}
