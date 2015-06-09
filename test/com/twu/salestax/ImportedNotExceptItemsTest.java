package com.twu.salestax;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImportedNotExceptItemsTest {
    @Test
    public void shouldCalculateTotalForImportedNotExcepetItems() {
        ImportedNotExceptItems importedNotExceptItems = new ImportedNotExceptItems();

        double actualPrice = importedNotExceptItems.calculatePrice(47.50);

        assertThat(actualPrice, is(54.65));
    }
}