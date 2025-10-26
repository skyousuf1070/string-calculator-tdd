package org.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static final String DEFAULT_DELIMITER = ",|\n";
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersToSplit = numbers;
        if (numbers.startsWith("//")) {
            delimiter = getDelimiter(numbers);
            numbersToSplit = numbers.substring(numbers.indexOf("\n") + 1);
        }
        return processAndSum(numbersToSplit.split(delimiter));
    }

    private static String getDelimiter(String numbers) {
        if (numbers.startsWith("//[")) {
            return String.join("|", extractDelimiters(numbers));
        }
        return Pattern.quote(String.valueOf(numbers.charAt(2)));
    }

    private static ArrayList<String> extractDelimiters(String numbers) {
        ArrayList<String> delimiters = new ArrayList<>();
        Matcher delimiterMatcher = Pattern.compile("\\[(.*?)]").matcher(numbers);
        while (delimiterMatcher.find()) {
            delimiters.add(Pattern.quote(delimiterMatcher.group(1)));
        }
        return delimiters;
    }

    private int processAndSum(String[] inputNumbers) {
        List<Integer> numbers = parseInputStringsToIntegers(inputNumbers);

        validateForNegatives(numbers);

        return calculateSumIgnoringLargeNumbers(numbers);
    }

    private static List<Integer> parseInputStringsToIntegers(String[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateForNegatives(List<Integer> numbers) {
        String commaSeparatedNegativeNumbers = formatNegativeNumbers(numbers);

        if (!commaSeparatedNegativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed " + commaSeparatedNegativeNumbers);
        }
    }

    private String formatNegativeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    private static int calculateSumIgnoringLargeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n <= 1000)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getCalledCount() {
        return callCount;
    }
}
