package com.divya.inventorymanagement.Service;

import java.sql.Date;
import java.util.List;

import com.divya.inventorymanagement.Model.Stock;

public interface StockService {


    List<Stock> getAllStocks();

    List<Stock> sortStockByQuantity();

    List<Stock> sortStockByLastUpdatedDate();

    void addStock(String productName, Integer quantitySupplied, Date LastUpdated);

    Stock getStockByProductName(String productName);

    void updateStockQuantityByProductName(String productName, Integer quantitySupplied, Date date);
    
    public void updateStockQuantity(String productName, Integer quantitySupplied, Date lastUpdated);
    
}
