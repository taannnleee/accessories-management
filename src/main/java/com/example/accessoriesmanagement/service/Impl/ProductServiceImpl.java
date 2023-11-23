package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.repositories.IProductCategoryRepository;
import com.example.accessoriesmanagement.repositories.IProductRepository;
import com.example.accessoriesmanagement.repositories.Impl.ProductCategoryRepositoryImpl;
import com.example.accessoriesmanagement.repositories.Impl.ProductRepositoryImpl;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();

    IProductCategoryRepository productCategoryRepository = new ProductCategoryRepositoryImpl();

    @Override
    public List<ProductDTO> selectProduct(){
        return Mappers.mapperEntityToDto(productRepository.selectProduct(),ProductDTO.class);
    }

    @Override
    public void insertProduct(ProductDTO productDTO)
    {
        Product product = Mappers.convertToEntity(productDTO, Product.class);
        ProductCategory productCategory = productCategoryRepository.getProductCategoryById(productDTO.getProductCategoryId());
        product.setProduct_category(productCategory);
        productRepository.insertProduct(product);
    }
    @Override
    public ProductDTO getProductById(Long productId){
        Product product = productRepository.getProductById(productId);
        return Mappers.convertToDto(product,ProductDTO.class);
    }

    @Override
    public void update(ProductDTO productDTO){
        Product product = Mappers.convertToEntity(productDTO, Product.class);
        productRepository.update(product);
    }
    @Override
    public void delete(ProductDTO productDTO){
        Product product = Mappers.convertToEntity(productDTO, Product.class);
        productRepository.delete(product);
    }
}
