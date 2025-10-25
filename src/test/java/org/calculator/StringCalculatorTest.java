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
}
