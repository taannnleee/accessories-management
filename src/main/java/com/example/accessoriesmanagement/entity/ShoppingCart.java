package com.example.accessoriesmanagement.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

@Entity
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long shoppingId;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "shop_order_id")
    private ShopOrder shop_order;

    @OneToMany(mappedBy = "shopping_cart",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Payment> payments;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "shopping_cart",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ShoppingCartItem> shoppingCartItems;

    public ShoppingCart() {

    }


    public ShoppingCart(Long shoppingId, double totalPrice, ShopOrder shop_order, User user) {
        this.shoppingId = shoppingId;
        this.totalPrice = totalPrice;
        this.shop_order = shop_order;
        this.user = user;
    }

    public Long getShoppingId() {
        return shoppingId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ShopOrder getShop_order() {
        return shop_order;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public User getUser() {
        return user;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void setShoppingId(Long shoppingId) {
        this.shoppingId = shoppingId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShop_order(ShopOrder shop_order) {
        this.shop_order = shop_order;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }
}