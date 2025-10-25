package org.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroWhenTheNumbersAreEmpty() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnTheSameNumberWhenOnlyOneNumberIsPassed() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(5, calculator.add("5"));
    }

    @Test
    public void shouldReturnTheSumOfTwoNumbersWhenTwoNumbersArePassedByCommaSeparated() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(7, calculator.add("5,2"));
        Assertions.assertEquals(12, calculator.add("4,8"));
    }

}
