package com.example.accessoriesmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productID;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "prices")
    private double productPrice;

    @Column(name = "image")
    private String productImage;  // Đây có thể là URL hoặc đường dẫn tới hình ảnh

    @Column(name = "quantity")
    private int productQuantity;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory product_category;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShoppingCartItem> shoppingCartItems;

}
