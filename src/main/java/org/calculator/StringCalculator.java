package org.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.startsWith("//")) {
            return calculateSum(numbers.substring(4).split(";"));
        } else {
            return calculateSum(numbers.split(",|\n"));
        }
    }

    private int calculateSum(String[] inputNumbers) {
        int sum = 0;
        for (String number : inputNumbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
