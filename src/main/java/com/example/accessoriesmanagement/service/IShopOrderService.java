package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.entity.ShopOrder;

import java.util.List;

public interface IShopOrderService {
    List<ShopOrder> selectShopOrder();
    void insertShopOrder(ShopOrder shopOrder);
    ShopOrder getShopOrderById(Long shopOrderId);
    void update(ShopOrder shopOrder);
    void deleteShopOrderById(Long shopOrderId);
}
