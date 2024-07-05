package com.zuna.API.DTOs;

import com.zuna.API.Entities.Product;

public class ProductDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isNew;
    private String location;
    private int views;

    public ProductDto() {}

    public ProductDto(
            int id, String name, String description,
            double price, boolean isNew, String location,
            int views
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isNew = isNew;
        this.location = location;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void mapToDto(Product product) {
        if (product != null) {
            this.setId(product.getId());
            this.setName(product.getName());
            this.setDescription(product.getDescription());
            this.setPrice(product.getPrice());
            this.setNew(product.isNew());
            this.setLocation(product.getLocation());
            this.setViews(product.getViews());
        }
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
