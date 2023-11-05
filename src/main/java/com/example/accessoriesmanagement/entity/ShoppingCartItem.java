package com.example.accessoriesmanagement.entity;

import javax.persistence.*;

@Entity
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_item_id")
    private Long shoppingCartItemId;

    @Column(name = "quantity")
    private String shoppingCartItemQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shopping_cart;

}
