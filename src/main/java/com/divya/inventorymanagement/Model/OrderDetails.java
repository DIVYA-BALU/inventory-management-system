package com.divya.inventorymanagement.Model;

import java.math.BigDecimal;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailsId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String email;

    private Date orderDate;

    private Integer quantityOrdered;

    private BigDecimal totalAmount;

    @Column(nullable = false)
    private Integer managerId ;
    
    
}
