package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.repositories.IShopOrderRepository;
import com.example.accessoriesmanagement.repositories.Impl.ShopOrderRepositoryImpl;
import com.example.accessoriesmanagement.service.IShopOrderService;

import java.util.List;

public class ShopOrderServiceImpl implements IShopOrderService {
    IShopOrderRepository shopOrderRepository = new ShopOrderRepositoryImpl();

    @Override
    public List<ShopOrder> selectShopOrder(){
        return shopOrderRepository.selectShopOrder();
    }

    public void insertShopOrder(ShopOrder shopOrder){
        shopOrderRepository.insertShopOrder(shopOrder);
    }

    public ShopOrder getShopOrderById(Long shopOrderId){
        return shopOrderRepository.getShopOrderById(shopOrderId);
    }

    public void update(ShopOrder shopOrder){
        shopOrderRepository.update(shopOrder);
    }

    public void deleteShopOrderById(Long shopOrderId){
        shopOrderRepository.deleteShopOrderById(shopOrderId);
    }
}
