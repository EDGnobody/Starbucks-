package com.starbucks.coffee_order.controller;


import com.starbucks.coffee_order.pojo.Result;
import com.starbucks.coffee_order.pojo.Store;
import com.starbucks.coffee_order.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/get_store_list")
    public Result<List<Store>> getStoreList() {
        List<Store> storeList = storeService.getAllStoresOrderedByProvince();
        return Result.success(storeList);
    }

    @GetMapping("/{province}")
    public Result<List<Store>> getStoresByProvince(@PathVariable String province) {
        List<Store> storeList = storeService.getStoresByProvince(province);
        if (storeList.isEmpty()) {
            return Result.error(404, "搜索失败，当前没有符合条件的店铺",null);
        } else {
            return Result.success(storeList);
        }
    }

    @PostMapping("/add")
    public Result<String> addStore(@Valid Store store) {
        storeService.add(store);
        return Result.success();
    }
}


