package com.zuna.API.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuna.API.DTOs.ProductDto;
import com.zuna.API.Entities.Product;
import com.zuna.API.Services.ProductService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = ProductsController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private Product product;
    private ProductDto productDto;

    @BeforeEach
    public void init() {
        product = new Product("Golf 4", "Neka deskripcija", "Doboj");
        productDto = new ProductDto();
        productDto.mapToDto(product);
    }

    @Test
    public void ProductController_Create_ReturnCreatedProduct() throws Exception {
        given(productService.create(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.name", CoreMatchers.is(productDto.getName())))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.location", CoreMatchers.is(productDto.getLocation())));
    }

    @Test
    public void ProductController_GetAll_ReturnProducts() throws Exception {
        List<ProductDto> productDtos = Collections.singletonList(productDto);

        when(productService.getAll()).thenReturn(productDtos);

        ResultActions response = mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.size()", CoreMatchers.is(productDtos.size())))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void ProductController_GetProductById_ReturnProduct() throws Exception {
        when(productService.findById(1)).thenReturn(productDto);

        ResultActions response = mockMvc.perform(get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(productDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location", CoreMatchers.is(productDto.getLocation())));
    }

    @Test
    public void ProductController_Update_ReturnUpdatedProduct() throws Exception {

        given(productService.update(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(put("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.name", CoreMatchers.is(productDto.getName())))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.location", CoreMatchers.is(productDto.getLocation())));
    }

    @Test
    public void ProductionController_Delete_ReturnProductionId() throws Exception {
        when(productService.delete(1)).thenReturn(1);

        ResultActions response = mockMvc.perform(delete("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", CoreMatchers.is(1)));
    }
}
