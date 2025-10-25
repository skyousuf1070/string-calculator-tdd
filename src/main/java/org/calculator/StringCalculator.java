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
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (String number : inputNumbers) {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                negativeNumbers.add(parsedNumber);
            }
            sum += parsedNumber;
        }
        if (!negativeNumbers.isEmpty()) {
            StringBuilder commaSeparatedNegativeNumbers = new StringBuilder();
            for (int index = 0; index < negativeNumbers.size(); index++) {
                commaSeparatedNegativeNumbers.append(negativeNumbers.get(index));
                if (index < negativeNumbers.size() - 1) {
                    commaSeparatedNegativeNumbers.append(", ");
                }
            }
            throw new IllegalArgumentException("negative numbers not allowed " + commaSeparatedNegativeNumbers);
        }
        return sum;
    }
}
