package org.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenTheNumbersAreEmpty() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnTheSameNumberWhenOnlyOneNumberIsPassed() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void shouldReturnTheSumOfTwoNumbersWhenTwoNumbersArePassedByCommaSeparated() {
        assertEquals(8, calculator.add("2,6"));
    }

    @Test
    public void shouldReturnTheSumOfMultipleNumbersWhenMultipleNumbersArePassedByCommaSeparated() {
        assertEquals(11, calculator.add("2,6,3"));
        assertEquals(10, calculator.add("1,2,3,4"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(55, calculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void shouldReturnTheSumOfNumbersWhenNumbersArePassedSeparatedByCommasAndNewLines() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void shouldReturnTheSumOfNumbersWhenNumbersArePassedSeparatedBySemiColonDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void shouldReturnTheSumOfNumbersWhenNumbersArePassedSeparatedByCustomDelimiter() {
        assertEquals(6, calculator.add("//|\n1|2|3"));
    }

    @Test
    public void shouldThrowAnExceptionWithNegativesNotAllowedMessageWhenOneNegativeNumberIsPassed() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add("1,2,-3"));
        assertEquals("negative numbers not allowed -3", exception.getMessage());
    }

    @Test
    public void shouldThrowAnExceptionWithNegativesNotAllowedCommaSeparatedNegativeNumbersMessageWhenNegativeNumbersArePassed() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2,-3"));
        assertEquals("negative numbers not allowed -1, -3", exception.getMessage());
    }

    @Test
    public void shouldNotAddToTheSumWhenNumberIsMoreThanThousand() {
        assertEquals(2, calculator.add("2,1002"));
    }

    @Test
    public void shouldSupportSingleCharacterCustomDelimiterInBrackets() {
        assertEquals(6, calculator.add("//[*]\n1*2*3"));
    }
}
