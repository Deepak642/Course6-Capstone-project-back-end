package com.simplilearn.medicalstore.controller;

import com.simplilearn.medicalstore.Entity.*;
import com.simplilearn.medicalstore.Entity.User;
import com.simplilearn.medicalstore.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepo;
    
    @Autowired
    private BrandRepository brandRepo;
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("category")
    public List<Category> getCategory()
    {
        List<Category> category = (List<Category>) categoryRepo.findAll();

        return category;
    }

 

    @GetMapping("brand")
    public List<Brand> getBrand()
    {
        List<Brand> brand = (List<Brand>) brandRepo.findAll();

        return brand;
    }



    @GetMapping("product")
    public List<Product> getProduct()
    {
        List<Product> product =  productRepo.findAll();

        return product;
    }


    @GetMapping("deletebrand")
    public Optional<Brand> deleteBrand(@RequestParam("id") long brandid) {
       Optional<Brand> brandRecord = brandRepo.findById(brandid);
        brandRepo.deleteByBrandId(brandid);
        return brandRecord;
    }

    @GetMapping("deletecategory")
    public Optional<Category> deleteCategory(@RequestParam("id") long categoryid) {
        Optional<Category> categoryRecord = categoryRepo.findById(categoryid);
        categoryRepo.deleteByCategoryId(categoryid);
        return categoryRecord;
    }

    @PostMapping("addbrand")
    public Brand addBrand(@RequestBody Brand brand) {
            Brand brandRecord = brandRepo.save(brand);
        return brandRecord;
    }

    @PostMapping("addcategory")
    public Category addCategory(@RequestBody Category category) {
        Category categoryRecord = categoryRepo.save(category);
        return categoryRecord;
    }


    @PostMapping("addproduct")
    public Product postProduct(@RequestBody AddProductAdmin addProductAdmin){
        Optional<Category> category = categoryRepo.findById(addProductAdmin.getCategory_id());
        Optional<Brand> brand = brandRepo.findById(addProductAdmin.getBrand_id());

        Category categoryProduct = category.get();
        Brand brandProduct = brand.get();
        Product product = new Product( addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
        Product productRecord = null;
        if (category.isPresent()&&brand.isPresent())

            productRecord = productRepo.save(product);
       
                return productRecord;

    }

    @GetMapping("productbyid")
    private Optional<Product> getBrandById(@RequestParam("id") long id)
    {
        Optional<Product> product = productRepo.findById(id);

        return product;
    }


    @GetMapping("deleteproduct")
    public Optional<Product> deleteProduct(@RequestParam("id") long productid) {
        Optional<Product> removedStore = productRepo.findById(productid);
        productRepo.deleteByProductId(productid);
        return removedStore;
    }



   
    @DeleteMapping("deleteallproductbybrand")
    public String deleteAllProductByBrand(@RequestParam("id") long brandid)
    {
        productRepo.deleteByBrandId(brandid);
        return "success.";
    }

    @DeleteMapping("deleteallproductbycategory")
    public String deleteAllProductByCategory(@RequestParam("id") long categoryid)
    {
        productRepo.deleteByCategoryId(categoryid);
        return "success.";
    }



   

    @PostMapping("registeradmin")
    private User registerAdmin(@RequestBody User user)
    {
        //user.setRole(user.getRole());
        user.setRole("ADMIN");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        User adminDetailsSave = null;
        adminDetailsSave = userRepo.save(user);

        return adminDetailsSave;
    }



 



    @PutMapping("updateproduct")
    public Product updateProduct(@RequestParam("id") long productId, @RequestBody AddProductAdmin addProductAdmin) {

        Product product = productRepo.findByProductId(productId);
        product.setName(addProductAdmin.getName());
        product.setDescription(addProductAdmin.getDescription());
        product.setUnitPrice(addProductAdmin.getUnitPrice());
        product.setImageUrl(addProductAdmin.getImageUrl());
        product.setActive(addProductAdmin.isActive());
        product.setUnitsInStock(addProductAdmin.getUnitsInStock());
        Product productRecord = null;

        productRecord = productRepo.save(product);

        return productRecord;
    }


}
