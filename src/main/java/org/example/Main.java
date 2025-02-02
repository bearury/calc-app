package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the expression:");
        String input = scanner.nextLine();

        String result = calc(input);
        System.out.printf("Result: %s", result);
    }


    public static String calc(String input) throws Exception {
        String inputWithoutSpaces = input.replaceAll("\\s+", "");

        String[] splitInputArray = inputWithoutSpaces.split("(?=[-+*/])|(?<=[-+*/])");

        if (splitInputArray.length != 3) {
            throw new Exception("Invalid expression");
        }

        int num1;
        int num2;
        String operation = splitInputArray[1];
        int result;

        try {
            num1 = Integer.parseInt(splitInputArray[0]);
            num2 = Integer.parseInt(splitInputArray[2]);
        } catch(NumberFormatException e) {
            throw new Exception("Invalid expression");
        }

        if ( (num1 > 10 || num1 < 0) || (num2 > 10 || num2 < 0)) {
            throw new Exception("Invalid expression");
        }

        result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new Exception("Invalid expression");
                }
                yield num1 / num2;
            }
            default -> throw new Exception("Invalid expression");
        };

        return String.valueOf(result);
    }
}