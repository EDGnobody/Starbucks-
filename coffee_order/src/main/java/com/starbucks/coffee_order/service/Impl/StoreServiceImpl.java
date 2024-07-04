package com.starbucks.coffee_order.service.Impl;


import com.starbucks.coffee_order.mapper.StoreMapper;
import com.starbucks.coffee_order.pojo.Store;
import com.starbucks.coffee_order.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getAllStoresOrderedByProvince() {
        return storeMapper.findAllOrderedByProvince();
    }

    @Override
    public List<Store> getStoresByProvince(String province) {
        return storeMapper.findByProvince(province);
    }

    @Override
    public void add(Store store) {
        storeMapper.add(store);
    }
}
