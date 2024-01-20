package com.divya.inventorymanagement.Service;

import java.util.List;

import com.divya.inventorymanagement.Model.OrderDetails;

public interface OrderDetailsService {

    OrderDetails addOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> getAllOrderDetails();

    OrderDetails getOrderDetailsById(int id);

    OrderDetails updateOrderDetailsById(OrderDetails orderDetails);

    String deleteOrderDetailsById(int id);
    
    List<OrderDetails> sortByDatePurchased();
}
