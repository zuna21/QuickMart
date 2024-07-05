package com.zuna.API.Repositories;

import com.zuna.API.Entities.Product;
import com.zuna.API.Repositories.Impl.ProductRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(ProductRepositoryImpl.class)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void ProductRepository_Create_ReturnCreatedProduct() {
        Product product = new Product("Golf 4", "Neka deskripcija", "Doboj");

        Product createdProduct = productRepository.create(product);

        Assertions.assertThat(createdProduct).isNotNull();
        Assertions.assertThat(createdProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void ProductRepository_Update_ReturnUpdatedProduct() {
        Product product = new Product("Golf 4", "Neka deskripcija", "Doboj");
        Product createdProduct = productRepository.create(product);

        String newName = "Golf 5";
        String newLocation = "Zenica";

        product.setName(newName);
        product.setLocation(newLocation);

        Product updatedProduct = productRepository.update(product);

        Assertions.assertThat(updatedProduct).isNotNull();
        Assertions.assertThat(updatedProduct.getId()).isGreaterThan(0);
        Assertions.assertThat(updatedProduct.getName()).isEqualTo(newName);
        Assertions.assertThat(updatedProduct.getLocation()).isEqualTo(newLocation);
    }

    @Test
    public void ProductRepository_FindById_ReturnProduct() {
        Product product = new Product();
        Product createdProduct = productRepository.create(product);

        Product selectedProduct = productRepository.findById(createdProduct.getId());

        Assertions.assertThat(selectedProduct).isNotNull();
        Assertions.assertThat(selectedProduct.getId()).isEqualTo(createdProduct.getId());
    }

    @Test
    public void ProductRepository_SelectAll_ReturnAllProducts() {
        Product product1 = new Product("Golf 1", "neka deskripcija", "Doboj");
        Product product2 = new Product("Golf 2", "Druga deskripcija", "Sarajevo");
        Product product3 = new Product("Golf 3", "Treca deskripcija", "Banja Luka");

        productRepository.create(product1);
        productRepository.create(product2);
        productRepository.create(product3);

        List<Product> products = productRepository.getAll();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(3);
    }

    @Test
    public void ProductRepository_Delete_ReturnVoid() {
        Product product = new Product("Golf 1", "neka deskripcija", "Doboj");

        Product createdProduct = productRepository.create(product);
        int deletedProduct = productRepository.delete(createdProduct.getId());
        Product findProduct = productRepository.findById(createdProduct.getId());

        Assertions.assertThat(deletedProduct).isGreaterThan(0);
        Assertions.assertThat(findProduct).isNull();
    }
}
