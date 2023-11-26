package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.User;

import java.util.List;

public interface IProductDao {
    User selectUser(String email);
    List<Product> get8Last();
    List<Product> get4NikeLast();
    List<Product> get4AdidasLast();
    List<Product> get4PumaLast();
    List<Product> get4AnanasLast();

    List<Product> getAllProducts();

    long countAllProduct();

    List<Product> getProductByIndex(int indexPage);
}
