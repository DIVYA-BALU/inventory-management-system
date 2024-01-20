package com.divya.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.inventorymanagement.Model.Stock;
import com.divya.inventorymanagement.Service.StockService;

@RestController
@RequestMapping("api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    // Post request to add stock
    @PostMapping("/addstock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        try{
            return ResponseEntity.ok(stockService.addStock(stock));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    // Get request to get all stocks
    @GetMapping("/getallstocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        try{
            return ResponseEntity.ok(stockService.getAllStocks());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    // Put request to update stock by id
    @PutMapping("/updatestockbyid")
    public ResponseEntity<Stock> updateStockById(Stock stock){
        try{
            return ResponseEntity.ok(stockService.updateStockById(stock));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    // Delete request to delete stock by id
    @DeleteMapping("/deletestockbyid/{id}")
    public ResponseEntity<String> deleteStockById(int id){
        try{
            return ResponseEntity.ok(stockService.deleteStockById(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    //sort and display stock by quanity in both ascending and descending order
    @GetMapping("/sortstockbyquantity")
    public ResponseEntity<List<Stock>> sortStockByQuantity(){
        try{
            return ResponseEntity.ok(stockService.sortStockByQuantity());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    //search stock by name
    @GetMapping("/searchstockbyname/{name}")
    public ResponseEntity<List<Stock>> searchStockByName(String name){
        try{
            return ResponseEntity.ok(stockService.searchStockByName(name));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    //dort stock by last updated date
    @GetMapping("/sortstockbylastupdateddate")
    public ResponseEntity<List<Stock>> sortStockByLastUpdatedDate(){
        try{
            return ResponseEntity.ok(stockService.sortStockByLastUpdatedDate());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    
}
