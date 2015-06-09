package com.twu.salestax;

public class ImportedNotExceptItems implements calculateTotalPrice {
    @Override
    public double calculatePrice(double originalPrice) {
        double serviceTax = (originalPrice * 15) / 100;
        serviceTax = RoundDouble.roundUp(serviceTax, 0.05);

        return originalPrice + serviceTax;
    }
}
