package com.starbucks.coffee_order.service;


import com.starbucks.coffee_order.pojo.Coffee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CoffeeService {
    void createCoffee(Coffee coffee);

    void update(Coffee coffee);

    void updateCategory(String category, Integer id);

    Coffee findByName(String name);

    List<Coffee> getCoffeeList();
}
