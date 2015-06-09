package com.twu.salestax;

public class NonImportedExceptItems implements calculateTotalPrice {
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice;
    }
}
