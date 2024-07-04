package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.Coffee;
import com.starbucks.coffee_order.pojo.Result;
import com.starbucks.coffee_order.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
@Valid
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeservice;

    @GetMapping("/get_coffee_list")
    public Result<List<Coffee>> getCoffeeList() {
        List<Coffee> cs = coffeeservice.getCoffeeList();
        if(cs == null) {
            return Result.error(312, "搜索失败，当前没有符合条件的咖啡",null);
        }
        else return Result.success(cs);
    }

    @PostMapping(value = "/create")
    public Result<String> createCoffee(String name,Integer price,String description,String category,String picture) {
        Coffee coffee = new Coffee();
        coffee.setName(name);
        coffee.setPrice(price);
        if(description != null) {
            coffee.setDescription(description);
        }
        if(category != null) {
            coffee.setCategory(category);
        }
        if (picture != null) {
            coffee.setPicture(picture);
        }
        try {
            coffeeservice.createCoffee(coffee);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(308, e.getMessage());
        }
    }
    @GetMapping("/{category}")
    public Result<List<Coffee>> getCoffee(@PathVariable String category) {
        List<Coffee> coffeeList = coffeeservice.findByCategory(category);
        if (coffeeList ==null){
            return Result.error(311,"分类不存在",null);
        }
        return Result.success(coffeeList);
    }

    @PutMapping("/updateCoffee")
    public Result<String> updateCoffee(Coffee coffee) {
        try {
            coffeeservice.update(coffee);
        } catch (Exception e) {
            return Result.error(309, e.getMessage());
        }
        return Result.success();
    }

    @PatchMapping("/updateCategory")
    public Result<String> updateCategory(@RequestParam(value = "category") String category,@RequestParam(value = "id") Integer id) {
        try {
            coffeeservice.updateCategory(category,id);
        } catch (Exception e) {
            return Result.error(310, e.getMessage());
        }
        return Result.success();
    }
}
