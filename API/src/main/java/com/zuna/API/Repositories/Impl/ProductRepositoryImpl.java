package com.zuna.API.Repositories.Impl;

import com.zuna.API.Entities.Product;
import com.zuna.API.Repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;

    @Autowired
    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Product create(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public Product findById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public int delete(int productId) {
        Product product = entityManager.find(Product.class, productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        entityManager.remove(product);
        return productId;
    }
}
