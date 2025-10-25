package org.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenTheNumbersAreEmpty() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnTheSameNumberWhenOnlyOneNumberIsPassed() {
        Assertions.assertEquals(5, calculator.add("5"));
    }

    @Test
    public void shouldReturnTheSumOfTwoNumbersWhenTwoNumbersArePassedByCommaSeparated() {
        Assertions.assertEquals(8, calculator.add("2,6"));
    }

    @Test
    public void shouldReturnTheSumOfMultipleNumbersWhenMultipleNumbersArePassedByCommaSeparated() {
        Assertions.assertEquals(11, calculator.add("2,6,3"));
        Assertions.assertEquals(10, calculator.add("1,2,3,4"));
        Assertions.assertEquals(15, calculator.add("1,2,3,4,5"));
        Assertions.assertEquals(55, calculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void shouldReturnTheSumOfNumbersWhenNumbersArePassedSeparatedByCommasAndNewLines() {
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void shouldReturnTheSumOfNumbersWhenNumbersArePassedSeparatedBySemiColonDelimiter() {
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
    }
}
