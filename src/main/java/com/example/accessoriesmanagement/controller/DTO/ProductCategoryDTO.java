package com.example.accessoriesmanagement.controller.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductCategoryDTO {

    private Long productCategoryID;

    private String categoryName;

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
}
