package org.calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.startsWith("//")) {
            String delimiter = String.valueOf(numbers.charAt(2));
            return calculateSum(numbers.substring(4).split(Pattern.quote(delimiter)));
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
