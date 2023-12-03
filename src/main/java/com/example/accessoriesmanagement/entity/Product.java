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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    private ProductCategory product_category;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ShoppingCartItem> shoppingCartItems;

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

    public Product() {

    }

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public ProductCategory getProduct_category() {
        return product_category;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProduct_category(ProductCategory product_category) {
        this.product_category = product_category;
    }

    public Product(Long productID, String productName, String productDescription, double productPrice, String productImage, int productQuantity, ProductCategory product_category) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.product_category = product_category;
    }
}
