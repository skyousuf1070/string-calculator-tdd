package org.calculator;

import java.util.ArrayList;
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
        ArrayList<Integer> negatives = new ArrayList<>();
        for (String number : inputNumbers) {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                negatives.add(parsedNumber);
            }
            sum += parsedNumber;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed " + negatives.getFirst());
        }
        return sum;
    }
}
