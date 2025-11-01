package org.calculator;

import java.util.List;

import static org.calculator.util.StringCalculatorConstants.DOUBLE_BACKWARD_SLASHES;
import static org.calculator.util.StringCalculatorConstants.DEFAULT_DELIMITER;
import static org.calculator.util.StringCalculatorConstants.DOUBLE_BACKWARD_SLASHES_WITH_OPEN_BRACKET;
import static org.calculator.util.StringCalculatorConstants.LINE_BREAK;
import static org.calculator.util.StringCalculatorConstants.NEGATIVE_NUMBERS_NOT_ALLOWED;
import static org.calculator.util.StringCalculatorHelper.getDelimiter;
import static org.calculator.util.StringCalculatorHelper.splitStringByDelimiter;
import static org.calculator.util.StringCalculatorHelper.parseInputStringsToIntegers;
import static org.calculator.util.StringCalculatorHelper.formatNegativeNumbers;
import static org.calculator.util.StringCalculatorHelper.calculateTotals;

public class StringCalculator {
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersToSplit = numbers;
        boolean isInputHasBracket = numbers.startsWith(DOUBLE_BACKWARD_SLASHES_WITH_OPEN_BRACKET);

        if (numbers.startsWith(DOUBLE_BACKWARD_SLASHES)) {
            delimiter = getDelimiter(numbers);
            numbersToSplit = numbers.substring(numbers.indexOf(LINE_BREAK) + 1);
        }

        String[] inputNumbers = splitStringByDelimiter(numbersToSplit, delimiter);
        return processAndCalculate(inputNumbers, delimiter, isInputHasBracket);
    }

    private int processAndCalculate(String[] inputNumbers, String delimiter, boolean isInputHasBracket) {
        List<Integer> numbers = parseInputStringsToIntegers(inputNumbers);

        validateForNegatives(numbers);

        return calculateTotals(numbers, delimiter, isInputHasBracket);
    }

    private void validateForNegatives(List<Integer> numbers) {
        String commaSeparatedNegativeNumbers = formatNegativeNumbers(numbers);

        if (!commaSeparatedNegativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(NEGATIVE_NUMBERS_NOT_ALLOWED + commaSeparatedNegativeNumbers);
        }
    }

    public int getCalledCount() {
        return callCount;
    }
}
