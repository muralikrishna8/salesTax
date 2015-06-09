package com.twu.salestax;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImportedExceptItemsTest {
    @Test
    public void shouldCalculateTotalForImportedExceptItems() {
        ImportedExceptItems importedExceptItems = new ImportedExceptItems();

        double actualPrice = importedExceptItems.calculatePrice(11.25);

        assertThat(actualPrice, is(11.85));
    }
}