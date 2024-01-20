package com.divya.inventorymanagement.Service;

import java.util.List;

import com.divya.inventorymanagement.Model.Product;

public interface ProductService {

    public Product addProduct(Product product);

    public List<Product> getProducts();

    public Product updateProduct(Product product);

    public String deleteProduct(Integer id);

    public List<Product> getProductByName(String name);

    public List<Product> getProductByCategory(String category);
    
}
