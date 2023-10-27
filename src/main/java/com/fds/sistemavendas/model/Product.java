package com.fds.sistemavendas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tb_product")
public class Product {

    @Id
    private Long id;

    private String description;
    
    private double price;

    private String image;

    public Product(Long id, String description, double price, String image) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    protected Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }
}
