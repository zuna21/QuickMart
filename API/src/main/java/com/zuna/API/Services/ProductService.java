package com.zuna.API.Services;

import com.zuna.API.DTOs.ProductDto;
import com.zuna.API.Entities.Product;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    ProductDto findById(int productId);
    List<ProductDto> getAll();
    int delete(int productId);
}
