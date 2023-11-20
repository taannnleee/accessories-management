package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectProduct();
    void insertProduct(Product product);
    Product getProductById(Long productId);
    void delete(Product product);
    void update(Product product);

}
