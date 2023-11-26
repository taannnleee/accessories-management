package com.example.accessoriesmanagement.DAO;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.util.List;

public interface ICategoryDao {
    List<ProductCategory> getAllCategory();
}
