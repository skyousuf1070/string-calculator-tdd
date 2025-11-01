package org.calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.calculator.util.StringCalculatorConstants.*;
import static org.calculator.util.StringCalculatorConstants.DELIMITER_SEPARATOR;

public class StringCalculatorHelper {
    public static String getDelimiter(String numbers) {
        if (numbers.startsWith(DOUBLE_BACKWARD_SLASHES_WITH_OPEN_BRACKET)) {
            return String.join(DELIMITER_SEPARATOR, extractDelimiters(numbers));
        }
        return Pattern.quote(String.valueOf(numbers.charAt(2)));
    }

    private static ArrayList<String> extractDelimiters(String numbers) {
        ArrayList<String> delimiters = new ArrayList<>();
        Matcher delimiterMatcher = Pattern.compile(ZERO_OR_MORE_CHARACTERS_REGEX).matcher(numbers);
        while (delimiterMatcher.find()) {
            delimiters.add(Pattern.quote(delimiterMatcher.group(1)));
        }
        return delimiters;
    }

    public static String[] splitStringByDelimiter(String numbersToSplit, String delimiter) {
        return numbersToSplit.split(delimiter);
    }

    public static List<Integer> parseInputStringsToIntegers(String[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String formatNegativeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public static int calculateTotals(List<Integer> numbers, String delimiter, boolean isInputHasBracket) {
        if (delimiter.equals(Pattern.quote(STAR_DELIMITER)) && !isInputHasBracket) {
            return calculateMultiplyIgnoringLargeNumbers(numbers);
        } else {
            return calculateSumIgnoringLargeNumbers(numbers);
        }
    }

    private static int calculateMultiplyIgnoringLargeNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(n -> n <= 100)
                .reduce(1, (num1, num2) -> num1 * num2);
    }

    private static int calculateSumIgnoringLargeNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(n -> n <= 100)
                .reduce(0, Integer::sum);
    }
}
