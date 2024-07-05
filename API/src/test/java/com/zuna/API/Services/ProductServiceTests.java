package com.zuna.API.Services;

import com.zuna.API.DTOs.ProductDto;
import com.zuna.API.Entities.Product;
import com.zuna.API.Repositories.ProductRepository;
import com.zuna.API.Services.Impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void ProductService_Create_ReturnProductDto() {
        Product product = new Product("Golf 4", "Neka deskripcija", "Doboj");
        ProductDto productDto = new ProductDto();
        productDto.mapToDto(product);

        when(productRepository.create(Mockito.any(Product.class))).thenReturn(product);

        ProductDto createdProduct = productService.create(productDto);

        Assertions.assertThat(createdProduct).isNotNull();
    }

    @Test
    public void ProductService_Update_ReturnProductDto() {
        ProductDto productDto = new ProductDto(
                1, "Ferrari", "Some description", 1250000,
                true, "Doboj", 0
        );
        Product product = new Product();
        product.mapToEntity(productDto);

        when(productRepository.update(Mockito.any(Product.class))).thenReturn(product);

        ProductDto updatedProduct = productService.update(productDto);

        Assertions.assertThat(updatedProduct).isNotNull();
        Assertions.assertThat(updatedProduct.getId()).isEqualTo(productDto.getId());
    }

    @Test
    public void ProductService_FindById_ReturnProductDto() {
        Product product = new Product("Citroen", "Some desc", "Sarajevo");

        when(productRepository.findById(1)).thenReturn(product);

        ProductDto searchedProduct = productService.findById(1);

        Assertions.assertThat(searchedProduct).isNotNull();
    }

    @Test
    public void ProductService_GetAll_ReturnAllProductDtos() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("Golf 1", "Deskripcija", "Mostar");
        Product product2 = new Product("Golf 2", "Desckripcija", "Bijelina");
        productList.add(product1);
        productList.add(product2);

        when(productRepository.getAll()).thenReturn(productList);
        List<ProductDto> productDtos = productService.getAll();

        Assertions.assertThat(productDtos).isNotNull();
        Assertions.assertThat(productDtos.size()).isEqualTo(2);
    }

    @Test
    public void ProductService_Delete_ReturnProductId() {
        when(productRepository.delete(1)).thenReturn(1);

        int deletedProductId = productService.delete(1);

        Assertions.assertThat(deletedProductId).isGreaterThan(0);
    }

}
