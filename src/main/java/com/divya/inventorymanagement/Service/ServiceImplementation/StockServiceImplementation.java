package com.divya.inventorymanagement.Service.ServiceImplementation;

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
    public String deleteStockById(int id) {
        try{
            stockRepository.deleteById(id);
            return "Stock deleted successfully";
        }catch(Exception e){
            return "Stock not found";
        }
    }

    @Override
    public Stock updateStockById(Stock stock) {
       try{
           Stock stockToUpdate = stockRepository.findById(stock.getStockId()).get();
           stockRepository.save(stockToUpdate);
           return stockToUpdate;
       }
       catch(Exception e){
           return null;
       }
    }

    @Override
    public Stock addStock(Stock stock) {
        try{
            return stockRepository.save(stock);
        }catch(Exception e){
            return null;
        }
    }

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
    public List<Stock> searchStockByName(String name) {
        try{
            return stockRepository.findByNameIgnoreCase(name);
            
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
    
}
