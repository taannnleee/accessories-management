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

    @Column(name = "size")
    private String size;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shopping_cart;

    public ShoppingCartItem() {

    }


    public ShoppingCartItem(Long shoppingCartItemId, String shoppingCartItemQuantity, Product product, ShoppingCart shopping_cart) {
        this.shoppingCartItemId = shoppingCartItemId;
        this.shoppingCartItemQuantity = shoppingCartItemQuantity;
        this.product = product;
        this.shopping_cart = shopping_cart;
    }

    public Long getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    public String getShoppingCartItemQuantity() {
        return shoppingCartItemQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public ShoppingCart getShopping_cart() {
        return shopping_cart;
    }

    public void setShoppingCartItemId(Long shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
    }

    public void setShoppingCartItemQuantity(String shoppingCartItemQuantity) {
        this.shoppingCartItemQuantity = shoppingCartItemQuantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setShopping_cart(ShoppingCart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
