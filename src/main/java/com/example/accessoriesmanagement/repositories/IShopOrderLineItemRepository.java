package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ShopOrderLineItem;

import java.util.List;

public interface IShopOrderLineItemRepository {
    List<ShopOrderLineItem> selectShopOrderLineItem();
    void insertShopOrderLineItem(ShopOrderLineItem shopOrderLineItem);
    ShopOrderLineItem getShopOrderLineItemById(Long shopOrderLineItemId);
    void update(ShopOrderLineItem shopOrderLineItem);
    void delete(ShopOrderLineItem shopOrderLineItem);
    void deleteShopOrderLineItemById(Long shopOrderLineItemId);
}
