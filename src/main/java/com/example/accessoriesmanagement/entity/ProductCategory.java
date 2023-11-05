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
}
