package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryRepository {
    List<ProductCategory> selectProductCategory();
    ProductCategory getProductCategoryById(Long productCategoryId);
}
