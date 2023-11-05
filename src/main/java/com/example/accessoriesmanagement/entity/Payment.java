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
}
