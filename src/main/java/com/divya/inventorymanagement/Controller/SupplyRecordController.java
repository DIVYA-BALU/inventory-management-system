package com.divya.inventorymanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.inventorymanagement.Model.SupplyRecord;
import com.divya.inventorymanagement.Service.SupplyRecordService;

@RestController
@RequestMapping("api/supplyrecord")
public class SupplyRecordController {
    
    @Autowired
    private SupplyRecordService supplyRecordService;
    
    // Post request to add supply record
    @PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF')")
    @PostMapping("/addsupplyrecord")
    public ResponseEntity<SupplyRecord> addSupplyRecord(@RequestBody SupplyRecord supplyRecord){
        try{
            return ResponseEntity.ok(supplyRecordService.addSupplyRecord(supplyRecord));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
       
    }
    // Get request to get all supply records
    @PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF') or hasRole('MANAGER')")
    @GetMapping("/getallsupplyrecords")
    public ResponseEntity<List<SupplyRecord>> getAllSupplyRecords(){
        try{
            return ResponseEntity.ok(supplyRecordService.getAllSupplyRecords());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Put request to update supply record by id
    @PreAuthorize("hasRole('ADMIN') or hasRole('WAREHOUSE_STAFF')")
    @PutMapping("/updatesupplyrecord")
    public ResponseEntity<SupplyRecord> updateSupplyRecord(@RequestBody SupplyRecord supplyRecord){
        try{
            return ResponseEntity.ok(supplyRecordService.updateSupplyRecord(supplyRecord));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
