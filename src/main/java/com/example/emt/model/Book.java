package com.example.emt.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Book {
    private Long id;
    private String name;

    @NotNull
    @Min(value = 10,message = "Price must be bigger than 10")
    private Integer price;
    private Integer quantity;


    public Book() {
    }

    public Book(Long id, String name, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
