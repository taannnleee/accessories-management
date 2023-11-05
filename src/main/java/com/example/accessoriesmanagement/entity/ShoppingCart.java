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

}
