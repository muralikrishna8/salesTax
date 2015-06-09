package com.twu.salestax;

import java.util.ArrayList;
import java.util.HashMap;

public class Billing {
    private HashMap<String, calculateTotalPrice> calculatePriceHash;
    private InputHandler inputHandler;
    private OutputHandler outputHander;
    private ArrayList<String> inputValues;
    private String bill;

    public Billing(HashMap<String, calculateTotalPrice> calculatePriceHash, InputHandler inputHandler,
                   OutputHandler outputHandler) {
        this.calculatePriceHash = calculatePriceHash;
        this.inputHandler = inputHandler;
        this.outputHander = outputHandler;
    }

    public void readInputs() {
        inputValues = new ArrayList<>();
        inputValues.add(inputHandler.read());
    }

    public void printBilling() {
        outputHander.print(bill);
    }

}
