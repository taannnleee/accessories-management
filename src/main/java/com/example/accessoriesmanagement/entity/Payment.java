package com.example.accessoriesmanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_payment")
    private Date datePayment;

    @Column(name = "method_payment")
    private String methodPayment;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shopping_cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getPaymentId() {
        return paymentId;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public ShoppingCart getShopping_cart() {
        return shopping_cart;
    }

    public User getUser() {
        return user;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public void setShopping_cart(ShoppingCart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment(Long paymentId, Date datePayment, String methodPayment, ShoppingCart shopping_cart, User user) {
        this.paymentId = paymentId;
        this.datePayment = datePayment;
        this.methodPayment = methodPayment;
        this.shopping_cart = shopping_cart;
        this.user = user;
    }
}
