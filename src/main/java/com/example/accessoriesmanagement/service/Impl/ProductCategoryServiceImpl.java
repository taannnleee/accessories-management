package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.repositories.IProductCategoryRepository;
import com.example.accessoriesmanagement.repositories.Impl.ProductCategoryRepositoryImpl;
import com.example.accessoriesmanagement.service.IProductCategoryService;

import java.util.List;


public class ProductCategoryServiceImpl implements IProductCategoryService {
    IProductCategoryRepository productCategoryRepository = new ProductCategoryRepositoryImpl();

    @Override
    public List<ProductCategoryDTO> selectProductCategory() {
        return Mappers.mapperEntityToDto(productCategoryRepository.selectProductCategory(),ProductCategoryDTO.class);
    }

    @Override
    public ProductCategoryDTO getProductCategoryById(Long productCategoryId){
        return Mappers.convertToDto(productCategoryRepository.getProductCategoryById(productCategoryId),ProductCategoryDTO.class);
    }

    @Override
    public void insertProductCategory(ProductCategory productCategory) {
        productCategoryRepository.insertProductCategory(productCategory);
    }
}
