package com.zuna.API.Entities;

import com.zuna.API.DTOs.ProductDto;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "is_new")
    private boolean isNew;

    @Column(name = "location")
    private String location;

    @Column(name = "views")
    private int views;

    public Product() {
        this.price = 0;
        this.isNew = true;
        this.views = 0;
    }

    public Product(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = 0;
        this.isNew = true;
        this.views = 0;
    }

    public Product(String name, String description, double price, boolean isNew, String location, int views) {
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

    public void mapToEntity(ProductDto productDto) {
        if (productDto != null) {
            this.setId(productDto.getId());
            this.setName(productDto.getName());
            this.setDescription(productDto.getDescription());
            this.setPrice(productDto.getPrice());
            this.setLocation(productDto.getLocation());
            this.setNew(productDto.isNew());
            this.setViews(productDto.getViews());
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
