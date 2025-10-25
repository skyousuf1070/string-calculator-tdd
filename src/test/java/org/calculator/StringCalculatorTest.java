package org.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroWhenTheNumbersAreEmpty() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(0, calculator.add(""));
    }
}
