package com.divya.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.inventorymanagement.Model.Stock;
import com.divya.inventorymanagement.Service.StockService;

@RestController
@RequestMapping("api/stock")
@PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF') or hasRole('MANAGER')")
public class StockController {
    @Autowired
    private StockService stockService;

    // Get request to get all stocks
    @GetMapping("/getallstocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        try{
            return ResponseEntity.ok(stockService.getAllStocks());
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

    //sort stock by last updated date
    @GetMapping("/sortstockbylastupdateddate")
    public ResponseEntity<List<Stock>> sortStockByLastUpdatedDate(){
        try{
            return ResponseEntity.ok(stockService.sortStockByLastUpdatedDate());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    
}
