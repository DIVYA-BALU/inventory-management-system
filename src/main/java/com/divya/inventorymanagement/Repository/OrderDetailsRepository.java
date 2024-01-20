package com.divya.inventorymanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.divya.inventorymanagement.Model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer>{

    //Query to display OrderDetails sorted by date purchased in descending order
    @Query("SELECT o FROM OrderDetails o ORDER BY o.orderDate DESC")
    List<OrderDetails> sortByDatePurchasedDesc();


}
