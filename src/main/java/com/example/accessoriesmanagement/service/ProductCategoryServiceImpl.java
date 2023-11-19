package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.repositories.IProductCategoryRepository;
import com.example.accessoriesmanagement.repositories.ProductCategoryRepositoryImpl;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.util.List;


public class ProductCategoryServiceImpl implements IProductCategoryService {
    IProductCategoryRepository productCategoryDao = new ProductCategoryRepositoryImpl();

    @Override
    public List<ProductCategory> selectProductCategory() {
        return productCategoryDao.selectProductCategory();
    }

}
