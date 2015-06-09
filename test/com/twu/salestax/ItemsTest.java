package com.twu.salestax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ItemsTest {
    @Test
    public void shouldGiveTheItemType() {
        HashMap<String, ArrayList<String>> typeAndItems = ItemsHashMap();
        String item = "chocolates";
        Items items = new Items(typeAndItems);

        String actualType = items.typeOf(item);

        assertEquals(actualType, "food");
    }
    @Test
    public void shouldGiveOtherWhenItemIsNotInDefinedList() {
        HashMap<String, ArrayList<String>> typeAndItems = ItemsHashMap();
        String item = "CD";
        Items items = new Items(typeAndItems);

        String actualType = items.typeOf(item);

        assertEquals(actualType, "other");
    }

    private HashMap<String, ArrayList<String>> ItemsHashMap(){
        HashMap<String, ArrayList<String>> typeAndItems = new HashMap<>();
        ArrayList<String> food = new ArrayList<>();
        food.add("chocolates");
        typeAndItems.put("food", food);
        ArrayList<String> books = new ArrayList<>();
        books.add("book");
        typeAndItems.put("books", books);

        return typeAndItems;
    }
}