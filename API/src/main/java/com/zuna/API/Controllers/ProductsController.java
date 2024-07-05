package com.zuna.API.Controllers;

import com.zuna.API.DTOs.ProductDto;
import com.zuna.API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @GetMapping("/{productId}")
    public ProductDto get(@PathVariable int productId) {
        return productService.findById(productId);
    }

    @DeleteMapping("/{productId}")
    public int delete(@PathVariable int productId) {
        return productService.delete(productId);
    }

    @PutMapping()
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @GetMapping()
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

}
