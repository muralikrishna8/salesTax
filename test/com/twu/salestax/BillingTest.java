package com.twu.salestax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BillingTest {
    @Mock
    InputHandler inputHandler;
    @Mock
    OutputHandler outputHandler;
    @Test
    public void shouldReadInput(){
        HashMap<String, calculateTotalPrice> hashMap = typesAndListeners();
        Billing billing = new Billing(hashMap, inputHandler, outputHandler);

        billing.readInputs();

        Mockito.verify(inputHandler).read();


    }

    @Test
    public void shouldPrintTheBilling(){
        HashMap<String, calculateTotalPrice> hashMap = typesAndListeners();
        Billing billing = new Billing(hashMap, inputHandler, outputHandler);

        billing.printBilling();

        Mockito.verify(outputHandler).print(null);


    }

    private HashMap<String, calculateTotalPrice> typesAndListeners() {
        HashMap<String, calculateTotalPrice> hashMap = new HashMap<>();
        hashMap.put("imported_food", new ImportedExceptItems());
        hashMap.put("imported_book", new ImportedExceptItems());
        hashMap.put("imported_cd", new ImportedNotExceptItems());
        hashMap.put("importedpills", new ImportedExceptItems());
        hashMap.put("imported_perfume", new ImportedNotExceptItems());
        hashMap.put("food", new NonImportedExceptItems());
        hashMap.put("book", new NonImportedExceptItems());
        hashMap.put("cd", new NotImportedNotExceptItems());
        hashMap.put("pills", new NonImportedExceptItems());
        hashMap.put("perfume", new NotImportedNotExceptItems());

        return hashMap;
    }
}