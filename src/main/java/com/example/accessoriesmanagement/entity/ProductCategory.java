package com.example.accessoriesmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productcategory")
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Long productCategoryID;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "product_category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products;

    public ProductCategory() {

    }

    public Long getProductCategoryID() {
        return productCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setProductCategoryID(Long productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory(Long productCategoryID, String categoryName) {
        this.productCategoryID = productCategoryID;
        this.categoryName = categoryName;
    }
}
