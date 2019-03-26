package com.monkeys;

import java.util.Scanner;

public class UserInput {
    static Scanner reader = new Scanner(System.in);  // Reading from System.in;
    public UserInput() {
    }

    public static int GetIntegerInput(String prompt) {
        System.out.println(prompt);
        return reader.nextInt(); // Scans the next token of the input as an int.

    }

    public static String GetStringInput(String prompt) {
        System.out.println(prompt);
        return reader.next(); // Scans the next token of the input as an int.
    }

    public static String GetStringLineInput(String prompt) {
        System.out.println(prompt);
        return reader.nextLine(); // Scans the next token of the input as an int.
    }
}
