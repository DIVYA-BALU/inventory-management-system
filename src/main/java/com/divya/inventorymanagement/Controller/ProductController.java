package com.divya.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.inventorymanagement.Model.Product;
import com.divya.inventorymanagement.Service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    //PostMapping for adding a product
    @PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF')")
    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try {
            return ResponseEntity.ok(productService.addProduct(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    //GetMapping for getting all products
    @PreAuthorize("hasRole('MANAGER') or hasRole('WAREHOUSE_STAFF') or hasRole('ADMIN')")
    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getProducts(){
        try {
            return ResponseEntity.ok(productService.getProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    //PutMapping for updating a product
    @PreAuthorize("hasRole('WAREHOUSE_STAFF') or hasRole('ADMIN')")
    @PutMapping("/updateproduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            return ResponseEntity.ok(productService.updateProduct(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    //DeleteMapping for deleting a product
    @PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF')")
    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(productService.deleteProduct(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('WAREHOUSE_STAFF') or hasRole('ADMIN')")
    @GetMapping("/getproductbyname/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(productService.getProductByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

     // GetMapping for getting a product by category ignore case as search functionality
     @PreAuthorize("hasRole('MANAGER') or hasRole('WAREHOUSE_STAFF') or hasRole('ADMIN')")
     @GetMapping("/getproductbycategory/{category}")
     public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
         try {
             return ResponseEntity.ok(productService.getProductByCategory(category));
         } catch (Exception e) {
             return ResponseEntity.badRequest().body(null);
         }
     }
}
