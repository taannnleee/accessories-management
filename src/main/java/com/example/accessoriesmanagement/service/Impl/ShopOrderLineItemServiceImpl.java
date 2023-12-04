package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.entity.ShopOrderLineItem;
import com.example.accessoriesmanagement.repositories.IShopOrderLineItemRepository;
import com.example.accessoriesmanagement.repositories.Impl.ShopOrderLineItemRepositoryImpl;
import com.example.accessoriesmanagement.service.IShopOrderLineItemService;

import java.util.List;

public class ShopOrderLineItemServiceImpl implements IShopOrderLineItemService   {
    IShopOrderLineItemRepository shopOrderLineItemRepository = new ShopOrderLineItemRepositoryImpl();
    @Override
    public List<ShopOrderLineItem> selectShopOrderLineItem() {
        return shopOrderLineItemRepository.selectShopOrderLineItem();
    }

    @Override
    public void insertShopOrderLineItem(ShopOrderLineItem shopOrderLineItem) {
        shopOrderLineItemRepository.insertShopOrderLineItem(shopOrderLineItem);
    }

    @Override
    public ShopOrderLineItem getShopOrderLineItemById(Long shopOrderLineItemId) {
        return shopOrderLineItemRepository.getShopOrderLineItemById(shopOrderLineItemId);
    }

    @Override
    public void update(ShopOrderLineItem shopOrderLineItem) {
        shopOrderLineItemRepository.update(shopOrderLineItem);
    }

    @Override
    public void delete(ShopOrderLineItem shopOrderLineItem) {
        shopOrderLineItemRepository.delete(shopOrderLineItem);
    }

    @Override
    public void deleteShopOrderLineItemById(Long shopOrderLineItemId) {
        shopOrderLineItemRepository.deleteShopOrderLineItemById(shopOrderLineItemId);
    }
}
