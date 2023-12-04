package com.example.accessoriesmanagement.controller.model;


import com.example.accessoriesmanagement.entity.ShoppingCartItem;

public class ShoppingCartItemInfo {
    public ShoppingCartItem shoppingCartItem;
    public double itemTotal;

    public ShoppingCartItemInfo(ShoppingCartItem shoppingCartItem, double itemTotal) {
        this.shoppingCartItem = shoppingCartItem;
        this.itemTotal = itemTotal;
    }

    public ShoppingCartItem getShoppingCartItem() {
        return shoppingCartItem;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItem = shoppingCartItem;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }
}

