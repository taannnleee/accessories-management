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
    private Date categoryName;

    @OneToMany(mappedBy = "product_category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products;

    public Long getProductCategoryID() {
        return productCategoryID;
    }

    public Date getCategoryName() {
        return categoryName;
    }

    public void setProductCategoryID(Long productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public void setCategoryName(Date categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory(Long productCategoryID, Date categoryName) {
        this.productCategoryID = productCategoryID;
        this.categoryName = categoryName;
    }
}
