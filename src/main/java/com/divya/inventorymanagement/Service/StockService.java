package com.divya.inventorymanagement.Service;

import java.util.List;

import com.divya.inventorymanagement.Model.Stock;

public interface StockService {

    Stock addStock(Stock stock);

    List<Stock> getAllStocks();

    Stock updateStockById(Stock stock);

    String deleteStockById(int id);

    List<Stock> sortStockByQuantity();

    List<Stock> searchStockByName(String name);

    List<Stock> sortStockByLastUpdatedDate();
    
    
}
