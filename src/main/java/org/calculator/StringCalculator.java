package org.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] inputNumbers = numbers.split(",");
        int sum = Integer.parseInt(inputNumbers[0]);
        if (inputNumbers.length > 1) {
            sum += Integer.parseInt(inputNumbers[1]);
        }
        return sum;
    }
}
