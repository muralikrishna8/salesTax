package com.twu.salestax;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class OutputHandlerTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldDisplayTheData() {
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.print("1 book : 12.49");


        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("1 book : 12.49\n")));
    }

}