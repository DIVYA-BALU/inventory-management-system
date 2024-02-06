package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Exception.StockNotAvailableException;
import com.divya.inventorymanagement.Model.OrderDetails;
import com.divya.inventorymanagement.Repository.OrderDetailsRepository;
import com.divya.inventorymanagement.Repository.StockRepository;
import com.divya.inventorymanagement.Service.OrderDetailsService;
import com.divya.inventorymanagement.Service.StockService;

@Service
public class OrderDetailsServiceImplementation implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private StockService stockService;

    @Autowired
    StockRepository stockRepository;

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        
            orderDetailsRepository.save(orderDetails);
            // get the quantity ordered and update the quantity in stock table
            int quantityOrdered = orderDetails.getQuantityOrdered();
            String productName = orderDetails.getProductName();
            Date datePurchased = orderDetails.getOrderDate();

            Integer stockQuantity = stockRepository.getStockQuantity(productName);

            System.out.println("Stock Quantity: " + quantityOrdered);
            if (stockQuantity < quantityOrdered) {
                throw new StockNotAvailableException("Stock not available");
            } else {
                stockService.updateStockQuantity(productName, quantityOrdered, datePurchased);
                return orderDetailsRepository.save(orderDetails);
            }

            // return orderDetailsRepository.save(orderDetails);
       
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        try {
            return orderDetailsRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public OrderDetails getOrderDetailsById(int id) {
        try {
            return orderDetailsRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
        try {
            OrderDetails orderDetailsToUpdate = orderDetailsRepository.findById(orderDetails.getOrderDetailsId()).get();
            orderDetailsRepository.save(orderDetailsToUpdate);
            return orderDetailsToUpdate;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String deleteOrderDetailsById(int id) {
        try {
            orderDetailsRepository.deleteById(id);
            return "Order details deleted successfully";
        } catch (Exception e) {
            return "Order details not found";
        }
    }

    @Override
    public List<OrderDetails> sortByDatePurchased() {
        try {
            return orderDetailsRepository.sortByDatePurchasedDesc();
        } catch (Exception e) {
            return null;
        }
    }

}
