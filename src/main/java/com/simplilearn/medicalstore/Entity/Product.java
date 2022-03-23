package com.simplilearn.medicalstore.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private Date createdOn;
    private Date updatedOn;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Brand brand;

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

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public BigDecimal getUnitPrice() {

        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {

        this.unitPrice = unitPrice;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public boolean isActive() {

        return active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    public int getUnitsInStock() {

        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {

        this.unitsInStock = unitsInStock;
    }

    public Date getCreatedOn() {

        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {

        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {

        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {

        this.updatedOn = updatedOn;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public Brand getBrand() {

        return brand;
    }

    public void setBrand(Brand brand) {

        this.brand = brand;
    }

    public Product(Long id, String name, String description, BigDecimal unitPrice, String imageUrl, boolean active, int unitsInStock, Date createdOn, Date updatedOn, Category category, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.category = category;
        this.brand = brand;
    }

    public Product( String name, String description, BigDecimal unitPrice, String imageUrl, boolean active, int unitsInStock, Category category, Brand brand) {
      
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.category = category;
        this.brand = brand;
        this.createdOn = new java.util.Date();
        this.updatedOn = new java.util.Date();
    }

    public Product() {
    }

}
