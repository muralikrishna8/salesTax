package com.twu.salestax;

import java.util.Scanner;

public class InputHandler {
    private Scanner inputScanner;
    public InputHandler() {
        inputScanner = new Scanner(System.in);
    }

    public String read() {
        return inputScanner.nextLine();
    }

    public int readInt() {
        return inputScanner.nextInt();
    }
}

