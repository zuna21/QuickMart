package com.zuna.API.Services.Impl;

import com.zuna.API.DTOs.ProductDto;
import com.zuna.API.Entities.Product;
import com.zuna.API.Repositories.ProductRepository;
import com.zuna.API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto productDto) {
        Product product = new Product();
        product.mapToEntity(productDto);
        Product createdProduct = productRepository.create(product);

        ProductDto createdProductDto = new ProductDto();
        createdProductDto.mapToDto(createdProduct);
        return createdProductDto;
    }

    @Override
    @Transactional
    public ProductDto update(ProductDto productDto) {
        Product product = new Product();
        product.mapToEntity(productDto);
        Product updatedProduct = productRepository.update(product);

        ProductDto updatedProductDto = new ProductDto();
        updatedProductDto.mapToDto(updatedProduct);
        return updatedProductDto;
    }

    @Override
    public ProductDto findById(int productId) {
        Product productWithId = productRepository.findById(productId);
        ProductDto productDto = new ProductDto();

        productDto.mapToDto(productWithId);
        return productDto;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.getAll();


        return products.stream()
                .map((product) -> {
                    ProductDto productDto = new ProductDto();
                    productDto.mapToDto(product);
                    return productDto;
                }).toList();
    }

    @Override
    @Transactional
    public int delete(int productId) {
        return productRepository.delete(productId);
    }
}
