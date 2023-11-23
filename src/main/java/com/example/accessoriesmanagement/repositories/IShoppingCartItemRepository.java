package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;

import java.util.List;

public interface IShoppingCartItemRepository {
    void deleteShoppingCartItem(ShoppingCartItem shoppingCartItem);
    void updateShoppingCartItem(ShoppingCartItem shoppingCartItem);
    ShoppingCartItem getShoppingCartItemById(Long shoppingCartItemId);
    void insertShoppingCartItem(ShoppingCartItem shoppingCartItem);
    List<ShoppingCartItem> selectShoppingCartItem();
}
