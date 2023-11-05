package com.example.accessoriesmanagement.entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long shopOrderId;

    @Column(name = "transaction_id_customer")             // có thể hàm sinh ngẫu nhiên nhung phải đảm bảo nó không trùng nhau
    private String transactionIdCustomer;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "shop_order_id")
    private ShopOrder shop_order;

    @OneToMany(mappedBy = "shopping_cart",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "shopping_cart",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShoppingCartItem> shoppingCartItems;

    public Long getShopOrderId() {
        return shopOrderId;
    }

    public String getTransactionIdCustomer() {
        return transactionIdCustomer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ShopOrder getShop_order() {
        return shop_order;
    }

    public User getUser() {
        return user;
    }

    public void setShopOrderId(Long shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public void setTransactionIdCustomer(String transactionIdCustomer) {
        this.transactionIdCustomer = transactionIdCustomer;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShop_order(ShopOrder shop_order) {
        this.shop_order = shop_order;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShoppingCart(Long shopOrderId, String transactionIdCustomer, double totalPrice, ShopOrder shop_order, User user) {
        this.shopOrderId = shopOrderId;
        this.transactionIdCustomer = transactionIdCustomer;
        this.totalPrice = totalPrice;
        this.shop_order = shop_order;
        this.user = user;
    }
}
