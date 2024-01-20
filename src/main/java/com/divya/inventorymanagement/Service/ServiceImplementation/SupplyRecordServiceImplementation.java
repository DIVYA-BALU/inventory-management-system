package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Model.SupplyRecord;
import com.divya.inventorymanagement.Repository.SupplyRecordRepository;
import com.divya.inventorymanagement.Service.SupplyRecordService;

@Service
public class SupplyRecordServiceImplementation implements SupplyRecordService{

    @Autowired
    private SupplyRecordRepository supplyRecordRepository;

    @Override
    public String deleteSupplyRecordById(int id) {
        try{
            supplyRecordRepository.deleteById(id);
            return "Supply record deleted successfully";
        }catch(Exception e){
            return "Supply record not found";
        }
    }

    @Override
    public SupplyRecord updateSupplyRecordById(SupplyRecord supplyRecord) {
       try{
           supplyRecordRepository.save(supplyRecord);
           return supplyRecord;
       }
       catch(Exception e){
           return null;
       }
    }


    @Override
    public SupplyRecord addSupplyRecord(SupplyRecord supplyRecord) {
        try{
            return supplyRecordRepository.save(supplyRecord);
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
