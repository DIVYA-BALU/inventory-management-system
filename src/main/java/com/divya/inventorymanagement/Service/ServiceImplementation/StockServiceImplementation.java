package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Model.Stock;
import com.divya.inventorymanagement.Repository.StockRepository;
import com.divya.inventorymanagement.Service.StockService;

@Service
public class StockServiceImplementation implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        try{
            return stockRepository.findAll();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Stock> sortStockByQuantity() {
        try{
            return stockRepository.sortStockByQuantity();
        }catch(Exception e){
            return null;
        } 
    }

    @Override
    public List<Stock> sortStockByLastUpdatedDate() {
        try{
            return stockRepository.sortStockByLastUpdatedDate();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void addStock(String productName, Integer quantitySupplied , Date LastUpdated) {
        Stock stock=new Stock();
        stock.setProductName(productName);
        stock.setQuantity(quantitySupplied);
        stock.setLastUpdated(LastUpdated);
        stockRepository.save(stock);
    }

    @Override
    public Stock getStockByProductName(String productName) {
       try{
           return stockRepository.findByNameIgnoreCase(productName);   
         }catch(Exception e){
                return null;
            }
    }

    @Override
    public void updateStockQuantityByProductName(String productName, Integer quantitySupplied, Date lastUpdated) {
        System.out.println(quantitySupplied);
        Stock stock=getStockByProductName(productName);
        stock.setQuantity(stock.getQuantity()+quantitySupplied);
        stock.setLastUpdated(lastUpdated);
        stockRepository.save(stock);
    }
    
    @Override
    public void updateStockQuantity(String productName, Integer quantityOrdered, Date lastUpdated) {
        Stock stock=getStockByProductName(productName);
        stock.setQuantity(stock.getQuantity()-quantityOrdered);
        stock.setLastUpdated(lastUpdated);
        stockRepository.save(stock);
    }
}
