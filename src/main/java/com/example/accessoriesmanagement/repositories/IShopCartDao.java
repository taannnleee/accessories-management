package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ShopOrder;

import java.util.List;

public interface IShopCartDao {
    void deleteShoppingCartByUserId(Long userId);
    List<ShopOrder> getAllShopOrders();
    List<ShopOrder> getAllShopItem();
    List<ShopOrder> getAllInvoiceByID(Long id);
    List<ShopOrder> getAllShopItemWithProducts();
}
