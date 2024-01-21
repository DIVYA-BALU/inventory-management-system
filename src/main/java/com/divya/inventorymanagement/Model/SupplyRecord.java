package com.divya.inventorymanagement.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplyId;

     @Column(nullable = false)
    private String supplierEmail;

    @Column(nullable = false)
    private String productName;

    private Date supplyDate;
    
    private Integer quantitySupplied;

    @Column(nullable = false)
    private Integer wareHouseStaffId;
    
}
