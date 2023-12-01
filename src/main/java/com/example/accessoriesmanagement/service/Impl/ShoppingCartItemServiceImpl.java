package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.repositories.IShoppingCartItemRepository;
import com.example.accessoriesmanagement.repositories.Impl.ShoppingCartItemRepositoryImpl;
import com.example.accessoriesmanagement.service.IShoppingCartItemService;

import java.util.List;

public class ShoppingCartItemServiceImpl implements IShoppingCartItemService {
    IShoppingCartItemRepository shoppingCartItemRepository = new ShoppingCartItemRepositoryImpl();
    @Override
    public void deleteShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemRepository.deleteShoppingCartItem(shoppingCartItem);
    }

    @Override
    public ShoppingCartItem updateShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.updateShoppingCartItem( shoppingCartItem);
    }

    @Override
    public ShoppingCartItem getShoppingCartItemById(Long shoppingCartItemId) {
        return shoppingCartItemRepository.getShoppingCartItemById(shoppingCartItemId);
    }

    @Override
    public void insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemRepository.insertShoppingCartItem(shoppingCartItem);
    }

    @Override
    public List<ShoppingCartItem> selectShoppingCartItem() {
        return shoppingCartItemRepository.selectShoppingCartItem();
    }

    @Override
    public List<ShoppingCartItem> selectShoppingCartItemByShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartItemRepository.selectShoppingCartItemByShoppingCart(shoppingCart);
    }
}
