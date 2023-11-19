package com.example.accessoriesmanagement.service;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.repositories.IProductRepository;
import com.example.accessoriesmanagement.repositories.ProductRepositoryImpl;
import com.example.accessoriesmanagement.entity.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<ProductDTO> selectProduct(){
        return Mappers.mapperEntityToDto(productRepository.selectProduct(),ProductDTO.class);
    }

}
