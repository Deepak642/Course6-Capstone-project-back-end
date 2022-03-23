package com.simplilearn.medicalstore;

import com.simplilearn.medicalstore.Entity.Brand;
import com.simplilearn.medicalstore.Entity.Category;
import com.simplilearn.medicalstore.Entity.Product;
import com.simplilearn.medicalstore.Repository.BrandRepository;
import com.simplilearn.medicalstore.Repository.CategoryRepository;
import com.simplilearn.medicalstore.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
    public class ProductTests {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void testCreateBrand(){
        Brand brand = new Brand("Neem");
        brandRepo.save(brand);
    }

    @Test
    public void testCreateCategory(){
        Category category = new Category("Face wash");
        categoryRepo.save(category);
    }

  


}
