package com.twu.salestax;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {
    private HashMap<String, ArrayList<String>> typeAndItems;

    public Items(HashMap<String, ArrayList<String>> typeAndItems) {
        this.typeAndItems = typeAndItems;
    }

    public String typeOf(String item) {
        for(String type : typeAndItems.keySet()){
            if(typeAndItems.get(type).contains(item)){
                return type;
            }
        }
        return "other";
    }
}
