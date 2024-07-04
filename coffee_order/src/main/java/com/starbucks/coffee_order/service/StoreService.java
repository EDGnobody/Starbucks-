package com.starbucks.coffee_order.service;



import com.starbucks.coffee_order.pojo.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStoresOrderedByProvince();

    List<Store> getStoresByProvince(String province);

    void add(Store store);
}
