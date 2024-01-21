package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Model.SupplyRecord;
import com.divya.inventorymanagement.Repository.SupplyRecordRepository;
import com.divya.inventorymanagement.Service.StockService;
import com.divya.inventorymanagement.Service.SupplyRecordService;

@Service
public class SupplyRecordServiceImplementation implements SupplyRecordService{

    @Autowired
    private SupplyRecordRepository supplyRecordRepository;

    @Autowired
    private StockService stockService;

    @Override
    public SupplyRecord updateSupplyRecord(SupplyRecord supplyRecord) {
       try{
          SupplyRecord supp = supplyRecordRepository.save(supplyRecord);
           return supp;
       }
       catch(Exception e){
           return null;
       }
    }


    @Override
    public SupplyRecord addSupplyRecord(SupplyRecord supplyRecord) {
        try{
           // condition to check if the product is already present in the stock then increment quantity of stock else add new stock details
            supplyRecordRepository.save(supplyRecord);
            if(stockService.getStockByProductName(supplyRecord.getProductName())!=null){
                stockService.updateStockQuantityByProductName(supplyRecord.getProductName(), supplyRecord.getQuantitySupplied(), supplyRecord.getSupplyDate());
            }
            else{
                stockService.addStock(supplyRecord.getProductName(), supplyRecord.getQuantitySupplied(), supplyRecord.getSupplyDate());
            }
            return  supplyRecordRepository.save(supplyRecord);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<SupplyRecord> getAllSupplyRecords() {
        try{
            return supplyRecordRepository.findAll();
        }catch(Exception e){
            return null;
        }
    }
    
}
