package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.util.List;

public interface ICategoryDao {
    List<ProductCategory> getAllCategory();
    Long getCateIDByProductID(Long id);
}
