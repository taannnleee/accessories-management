package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.entity.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    void deleteShoppingCart(ShoppingCart shoppingCart);
    void updateShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCartById(Long shoppingCartId);
    void insertShoppingCart(ShoppingCart shoppingCart);
    List<ShoppingCart> selectShoppingCart();
}
