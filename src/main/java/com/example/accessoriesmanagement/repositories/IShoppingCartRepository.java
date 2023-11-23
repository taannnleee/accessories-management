package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ShoppingCart;

import java.util.List;

public interface IShoppingCartRepository {
    void deleteShoppingCart(ShoppingCart shoppingCart);
    void updateShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCartById(Long shoppingCartId);
    void insertShoppingCart(ShoppingCart shoppingCart);
    List<ShoppingCart> selectShoppingCart();
}
