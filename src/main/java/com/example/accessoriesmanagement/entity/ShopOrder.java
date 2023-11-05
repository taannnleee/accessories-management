package com.example.accessoriesmanagement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class ShopOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_order_id")
    private Long shopOrderId;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "address_shipping")
    private String addressShipping;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "shop_order",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShoppingCart> shoppingCarts;

    public ShopOrder() {

    }

    public Long getShopOrderId() {
        return shopOrderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getAddressShipping() {
        return addressShipping;
    }

    public User getUser() {
        return user;
    }

    public void setShopOrderId(Long shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setAddressShipping(String addressShipping) {
        this.addressShipping = addressShipping;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShopOrder(Long shopOrderId, Date orderDate, double totalPrice, String orderStatus, String addressShipping, User user) {
        this.shopOrderId = shopOrderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.addressShipping = addressShipping;
        this.user = user;
    }
}
