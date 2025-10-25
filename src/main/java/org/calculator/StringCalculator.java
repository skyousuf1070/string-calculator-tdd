package org.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] inputNumbers = numbers.split(",");
        for (String number : inputNumbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
