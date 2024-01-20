package com.divya.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.divya.inventorymanagement.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

    //Query to find products by name by ignoring case
    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) = LOWER(:productName)")
    List<Product> findByProductNameIgnoreCase(String productName);

    //Query to find products by category by ignoring case
    @Query("SELECT p FROM Product p WHERE LOWER(p.category) = LOWER(:category)")
    List<Product> findByCategoryIgnoreCase(String category);

}
