package com.twu.salestax;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputHandlerTest {
    private ByteArrayInputStream byteArrayInputStream;

    @Before
    public void setUp() {
    }

    @Test
    public void shouldReadTheItemsDetails() {
        String input = "1 book at 12.49";
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        InputHandler inputOutputHandler = new InputHandler();

        String actualInput = inputOutputHandler.read();

        assertThat(actualInput, is("1 book at 12.49"));
    }
}