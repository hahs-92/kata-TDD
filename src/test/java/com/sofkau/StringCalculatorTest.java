package com.sofkau;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("An empty string returns zero")
    public void emptyStringTest() throws Exception {
        //arrange
        String input = "";
        int expectValue = 0;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("A single number returns the value")
    public void singleNumberReturnItsValueTest() throws Exception {
        //arrange
        String input = "2";
        int expectValue = 2;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("Two numbers, comma delimited, returns the sum")
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        //arrange
        String input = "2, 4";
        int expectValue = 6;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("Two numbers, newline delimited, returns the sum")
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        //arrange
        String input = "2\n2";
        int expectValue = 4;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("Three numbers, delimited either way, returns the sum")
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        //arrange
        String input = "2\n2,3";
        int expectValue = 7;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("Negative numbers throw an exception")
    public void negativeNumbersThrowsAnExceptionTest() throws Exception {
        //arrange
        String input = "-3, -1";
        String expectValue = "Not negative numbers";

        //act
        Exception exception = assertThrows(ArithmeticException.class, () -> stringCalculator.add(input));
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, exception.getMessage());
    }

    @Test
    @DisplayName("Numbers greater than 1000 are ignored")
    public void greaterThan1000AreIgnoredTest() throws Exception {
        //arrange
        String input = "2,1001";
        int expectValue = 2;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }

    @Test
    @DisplayName("A single char delimiter can be defined on the first line")
    public void singleCharDelimiterTest() throws Exception {
        //arrange
        String input = "#2#1000";
        int expectValue = 1002;

        //act
        var result = stringCalculator.add(input);

        //Assert
        assertEquals(expectValue, result);
    }
}
