package com.example.arep.properties.model;


import jakarta.persistence.*;


@Entity
@Table(name = "properties")
public class Property {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String address;


    @Column(nullable = false)
    private Double price;


    @Column(nullable = false)
    private Double size;


    @Column(length = 2000)
    private String description;


    // constructors
    public Property() {}


    public Property(String address, Double price, Double size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }


    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }


    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }


    public Double getSize() { return size; }
    public void setSize(Double size) { this.size = size; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}