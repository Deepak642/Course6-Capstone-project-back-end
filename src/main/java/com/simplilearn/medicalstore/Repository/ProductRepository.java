package com.simplilearn.medicalstore.Repository;


import com.simplilearn.medicalstore.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {



    @Transactional
    @Modifying
    @Query("delete from Product pe where pe.brand.id=:brandId")

    void deleteByBrandId(@Param("brandId")long brandid);

    @RestResource(path = "categoryid")
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    @RestResource(path = "brandid")
    Page<Product> findByBrandId(@Param("id") Long id, Pageable pageable);

    @RestResource(path = "searchbykeyword")
    Page<Product> findByNameContaining(@Param("name") String keyword, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from Product pe where pe.category.id=:categoryId")
    void deleteByCategoryId(@Param("categoryId")long categoryid);

    //delete product by product id
    @Transactional
    @Modifying
    @Query("delete from Product pe where pe.id=:productId")
    void deleteByProductId(@Param("productId")long productid);

    @Query("select pe from Product pe where pe.brand.id=:brandId")
    List<Product> findByBrandProduct(@Param("brandId")long brandid);

    @Query("select pe from Product pe where pe.category.id=:categoryId")
    List<Product> findByCategoryProduct(@Param("categoryId")long categoryId);

    @Query("select pe from Product pe where pe.id=:productId")
    Product findByProductId(@Param("productId")long productId);

}
