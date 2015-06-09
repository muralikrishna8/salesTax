package com.twu.salestax;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonImportedExceptItemsTest {
    @Test
    public void shouldCalculateTotalForNotImportedNotExceptItems() {
        NonImportedExceptItems nonImportedExceptItems = new NonImportedExceptItems();

        double actualPrice = nonImportedExceptItems.calculatePrice(12.49);

        assertEquals(12.49, actualPrice, 0.00d);
    }
}