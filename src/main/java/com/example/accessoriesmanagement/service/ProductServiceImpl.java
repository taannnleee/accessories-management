package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.repositories.IProductRepository;
import com.example.accessoriesmanagement.repositories.ProductRepositoryImpl;
import com.example.accessoriesmanagement.entity.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    IProductRepository productDao = new ProductRepositoryImpl();

    @Override
    public List<Product> selectProduct(){
        return  productDao.selectProduct();
    }

}
