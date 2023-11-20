package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.repositories.IProductCategoryRepository;
import com.example.accessoriesmanagement.repositories.ProductCategoryRepositoryImpl;
import com.example.accessoriesmanagement.entity.ProductCategory;

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
}
