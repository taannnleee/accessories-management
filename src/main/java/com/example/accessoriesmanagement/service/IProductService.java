package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> selectProduct();
    void insertProduct(ProductDTO productDTO);
    ProductDTO getProductById(Long productId);
    void delete(ProductDTO productDTO);
    void update(ProductDTO productDTO);
    void deleteProductById(Long productId);
}
