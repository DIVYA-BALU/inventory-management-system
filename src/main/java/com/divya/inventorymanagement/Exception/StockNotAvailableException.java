package com.divya.inventorymanagement.Exception;

public class StockNotAvailableException extends RuntimeException{

    public StockNotAvailableException(String message) {
        super(message);
    }
    
}
