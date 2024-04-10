package com.kodilla.hibernate.invoice;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    private int id;
    private String name;

    public Product() {

    }
    public Product(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true)
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
}