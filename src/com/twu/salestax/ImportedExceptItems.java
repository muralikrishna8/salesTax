package com.twu.salestax;

public class ImportedExceptItems implements calculateTotalPrice{
    @Override
    public double calculatePrice(double originalPrice) {
        double serviceTax = (originalPrice * 5) / 100;
        serviceTax = RoundDouble.roundUp(serviceTax, 0.05);

        return originalPrice + serviceTax;
    }
}
