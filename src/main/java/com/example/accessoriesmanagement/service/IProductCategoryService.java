package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategoryDTO> selectProductCategory();
    ProductCategoryDTO getProductCategoryById(Long productCategoryId);
    void insertProductCategory(ProductCategory productCategory);
}
