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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private BrandRepository brandRepo;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("product")
    public List<Product> getProduct()
    {
        List<Product> product = (List<Product>) productRepo.findAll();
        return product;
    }

    @GetMapping("brand")
    public List<Brand> getBrand()
    {
        List<Brand> brand = (List<Brand>) brandRepo.findAll();
        return brand;
    }

    @GetMapping("category")
    public List<Category> getCategory()
    {
        List<Category> category = (List<Category>) categoryRepo.findAll();
        return category;
    }

    @GetMapping("brandid")
    private Optional<Brand> getBrandById(@RequestParam("id") long brandid)
    {
        Optional<Brand> brandById = brandRepo.findById(brandid);
        return brandById;
    }

    @GetMapping("productid")
    private Optional<Product> getProductById(@RequestParam("id") long productid)
    {
        Optional<Product> productById = productRepo.findById(productid);
        return productById;
    }

    @GetMapping("categoryid")
    private Optional<Category> getCategoryById(@RequestParam("id") long categoryid)
    {
        Optional<Category> categoryById = categoryRepo.findById(categoryid);
        return categoryById;
    }

    @GetMapping("brandproducts")
    private List<Product> getBrandProduct(@RequestParam("id") long brandid)
    {
        List<Product> brandProduct = productRepo.findByBrandProduct(brandid);
        return brandProduct;
    }

    @GetMapping("categoryproducts")
    private List<Product> getCategoryProduct(@RequestParam("id") long categoryid)
    {
        List<Product> categoryProduct = productRepo.findByCategoryProduct(categoryid);
        return categoryProduct;
    }



 

    @PostMapping("register")
    public User auth(@RequestBody User user)
    {
        user.setRole("USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        User userDetailsSave = null;
        userDetailsSave = userRepo.save(user);

        return userDetailsSave;
    }






}
