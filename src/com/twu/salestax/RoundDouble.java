package com.twu.salestax;

public class RoundDouble {
    public double roundUp(double value, double step) {
        double multiplicand = Math.ceil(value / step);
        return step * multiplicand;
    }
}
