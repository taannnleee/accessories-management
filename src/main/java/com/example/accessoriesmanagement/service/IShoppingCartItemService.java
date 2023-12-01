package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;

import java.util.List;

public interface IShoppingCartItemService {
    void deleteShoppingCartItem(ShoppingCartItem shoppingCartItem);
    ShoppingCartItem updateShoppingCartItem(ShoppingCartItem shoppingCartItem);
    ShoppingCartItem getShoppingCartItemById(Long shoppingCartItemId);
    void insertShoppingCartItem(ShoppingCartItem shoppingCartItem);
    List<ShoppingCartItem> selectShoppingCartItem();
    List<ShoppingCartItem> selectShoppingCartItemByShoppingCart(ShoppingCart shoppingCart);
}
