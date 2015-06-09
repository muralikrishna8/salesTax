package com.twu.salestax;

public class NotImportedNotExceptItems implements calculateTotalPrice {
    @Override
    public double calculatePrice(double originalPrice) {
        double serviceTax = (originalPrice * 10) / 100;
        serviceTax = RoundDouble.roundUp(serviceTax, 0.05);

        double total = originalPrice + serviceTax;

        return total;
    }
}
