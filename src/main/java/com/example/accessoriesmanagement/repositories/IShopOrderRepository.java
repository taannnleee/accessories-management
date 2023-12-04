package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ShopOrder;

import java.util.List;

public interface IShopOrderRepository {
    List<ShopOrder> selectShopOrder();
    void insertShopOrder(ShopOrder shopOrder);
    ShopOrder getShopOrderById(Long shopOrderId);
    void update(ShopOrder shopOrder);
    void delete(ShopOrder shopOrder);
    void deleteShopOrderById(Long shopOrderId);
}
