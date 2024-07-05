package com.zuna.API.Repositories;

import com.zuna.API.Entities.Product;

import java.util.List;

public interface ProductRepository {
    Product create(Product product);
    Product update(Product product);
    Product findById(int productId);
    List<Product> getAll();
    int delete(int productId);
}
