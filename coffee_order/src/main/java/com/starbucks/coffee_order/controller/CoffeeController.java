package com.starbucks.coffee_order.controller;

import com.starbucks.coffee_order.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @GetMapping("/getCoffeeList")
    public Result<String> get_coffee_list(){
        return Result.success("咖啡列表");
    }
}
