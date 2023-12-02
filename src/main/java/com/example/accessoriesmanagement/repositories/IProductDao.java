package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.User;

import java.util.List;
import java.util.function.LongFunction;

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
    List<Product> searchByName(String txtSearch);
    List<Product> getProductById(Long cid);
    List<Product> getProductUnder1000();
    List<Product> getProductOver2000();
    List<Product> getProduct1000to2000();
    List<Product> getProductMinToMax(double priceMin, double priceMax);
    Product getProductByIdProduct(Long cid);
    List<Product> getRelatedProduct(Long cateIDProductDetail);

}
