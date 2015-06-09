package com.twu.salestax;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotImportedNotExceptItemsTest {
    @Test
    public void shouldCalculateTotalForNotImportedNotExceptItems() {
        NotImportedNotExceptItems notImportedNotExceptItems = new NotImportedNotExceptItems();

        double actualPrice = notImportedNotExceptItems.calculatePrice(14.99);

        assertEquals(16.49, actualPrice, 0.001);
    }
}