package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IShoppingCartRepository;
import com.example.accessoriesmanagement.repositories.Impl.ShoppingCartRepositoryImpl;
import com.example.accessoriesmanagement.service.IShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements IShoppingCartService {

    IShoppingCartRepository shoppingCartRepository = new ShoppingCartRepositoryImpl();
    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.deleteShoppingCart(shoppingCart);
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.updateShoppingCart(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCartById(Long shoppingCartId) {
        return shoppingCartRepository.getShoppingCartById(shoppingCartId);
    }

    @Override
    public void insertShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.insertShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCart> selectShoppingCart() {
        return shoppingCartRepository.selectShoppingCart();
    }

    public ShoppingCart getShoppingCartByUser(User user){
        return shoppingCartRepository.getShoppingCartByUser(user);
    }

}
