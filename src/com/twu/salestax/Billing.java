package com.twu.salestax;

import java.util.ArrayList;
import java.util.HashMap;

public class Billing {
    private HashMap<String, calculateTotalPrice> calculatePriceHash;
    private Items items;
    private InputHandler inputHandler;
    private OutputHandler outputHander;
    private ArrayList<String> inputValues;
    private String bill = "";
    private double totalSalesTax = 0.0;
    private double total = 0.0;

    public Billing(HashMap<String, calculateTotalPrice> calculatePriceHash,
                   HashMap<String, ArrayList<String>> typeAndItems,
                   InputHandler inputHandler,
                   OutputHandler outputHandler) {
        this.calculatePriceHash = calculatePriceHash;
        this.inputHandler = inputHandler;
        this.outputHander = outputHandler;
        this.items = new Items(typeAndItems);
        readInputs();
    }

    public void readInputs() {
        inputValues = new ArrayList<>();
        outputHander.print("Enter How Many Items: ");
        int numberOfItems = inputHandler.readInt();
        String temp = inputHandler.read();
        for (int i = 0; i < numberOfItems; i++) {
            inputValues.add(inputHandler.read());
        }
        calculateBilling();
    }

    public void calculateBilling() {
        for (int i = 0; i < inputValues.size(); i++) {
            if(inputValues.get(i) != null) {
                String type = "";
                String splittedItem[] = inputValues.get(i).split(" ");
                String outputItem = "";
                int j;
                for (j = 1; j < (splittedItem.length - 1); j++) {
                    if (splittedItem[j].equals("imported")) {
                        type += "imported_";
                    }
                    if (!items.typeOf(splittedItem[j]).equals("other")) {
                        type += items.typeOf(splittedItem[j]);
                    }
                    outputItem += (splittedItem[j] + " ");
                }
                double originalPrice = Double.parseDouble(splittedItem[j]);

                double priceOfItem = calculatePriceHash.get(type).calculatePrice(originalPrice);

                totalSalesTax += (priceOfItem - originalPrice);

                total += priceOfItem;

                bill += (outputItem + ":" +priceOfItem + "\n");
            }
        }
        bill += ("Sales Tax:" + totalSalesTax + "\n");
        bill += ("Total : " +total + "\n");
        printBilling();
    }

    public void printBilling() {
        outputHander.print(bill);
    }

    public static void main(String[] args) {
        HashMap<String, calculateTotalPrice> hashMap = new HashMap<>();
        hashMap.put("imported_food", new ImportedExceptItems());
        hashMap.put("imported_book", new ImportedExceptItems());
        hashMap.put("imported_CD", new ImportedNotExceptItems());
        hashMap.put("imported_pills", new ImportedExceptItems());
        hashMap.put("imported_perfume", new ImportedNotExceptItems());
        hashMap.put("food", new NonImportedExceptItems());
        hashMap.put("book", new NonImportedExceptItems());
        hashMap.put("CD", new NotImportedNotExceptItems());
        hashMap.put("pills", new NonImportedExceptItems());
        hashMap.put("perfume", new NotImportedNotExceptItems());


        HashMap<String, ArrayList<String>> typeAndItems = new HashMap<>();
        ArrayList<String> food = new ArrayList<>();
        food.add("chocolates");
        food.add("chocolate");
        typeAndItems.put("food", food);
        ArrayList<String> books = new ArrayList<>();
        books.add("book");
        typeAndItems.put("book", books);
        ArrayList<String> cds = new ArrayList<>();
        cds.add("CD");
        typeAndItems.put("CD", cds);
        ArrayList<String> pills = new ArrayList<>();
        pills.add("pills");
        typeAndItems.put("pills", pills);
        ArrayList<String> perfume = new ArrayList<>();
        perfume.add("perfume");
        typeAndItems.put("perfume", perfume);


        new Billing(hashMap, typeAndItems, new InputHandler(), new OutputHandler());
    }

}
