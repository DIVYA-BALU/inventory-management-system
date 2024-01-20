package com.divya.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.divya.inventorymanagement.Model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{

    //Query to sort stock by quantity
    @Query("SELECT s FROM Stock s ORDER BY s.quantity DESC")
    List<Stock> sortStockByQuantity();

    //Query to find stock by name by ignoring case
    @Query("SELECT s FROM Stock s WHERE LOWER(s.productName) = LOWER(:name)")
    List<Stock> findByNameIgnoreCase(String name);

    //Query to sort stock by last updated date
    @Query("SELECT s FROM Stock s ORDER BY s.LastUpdated DESC")
    List<Stock> sortStockByLastUpdatedDate();
    
}
