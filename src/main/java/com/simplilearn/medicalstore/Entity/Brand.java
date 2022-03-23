package com.simplilearn.medicalstore.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String brandName;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="brand")
    private Set<Product> product;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getBrandName() {

        return brandName;
    }

    public void setBrandName(String brandName) {

        this.brandName = brandName;
    }

    public Brand() {
    }

    public Brand(String brandName) {

        this.brandName = brandName;
    }

}
