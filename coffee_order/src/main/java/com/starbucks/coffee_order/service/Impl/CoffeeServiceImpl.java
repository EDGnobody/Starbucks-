package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.CoffeeMapper;
import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeMapper coffeemapper;

    public void createCoffee(Coffee coffee) {
        if (coffeemapper.findByName(coffee.getName()) != null) {
            throw new RuntimeException("咖啡名已存在");
        }
        coffeemapper.create(coffee);
    }

    @Override
    public void update(Coffee coffee) {
        Coffee old_coffee = coffeemapper.findById(coffee.getId());
        if (old_coffee == null) {
            throw new RuntimeException("咖啡不存在");
        }
        coffeemapper.update(coffee);
    }

    @Override
    public void updateCategory(String category, Integer id) {
        if(coffeemapper.findById(id) == null) {
            throw new RuntimeException("咖啡不存在");
        }
        coffeemapper.updateCategory(category, id);
    }

    @Override
    public Coffee findByName(String name) {
        return coffeemapper.findByName(name);
    }

    @Override
    public List<Coffee> getCoffeeList() {
        return coffeemapper.get_category_list();
    }

}

