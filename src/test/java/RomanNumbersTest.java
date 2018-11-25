import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumbersTest {

    @Test
    public void shouldReturn0IfRomanNumberIsEmpty() {
        //given
        RomanNumbers romanNumbers = new RomanNumbers();
        //when
        String result = romanNumbers.convertRomanNumberToArabicNumber("");
        //then
        assertEquals("0", result);
    }

    @Test
    public void shouldReturn0IfNumberContainsNotOnlyRomanNumbers() {
        //given
        RomanNumbers romanNumbers = new RomanNumbers();
        //when
        String result = romanNumbers.convertRomanNumberToArabicNumber("1V");
        //then
        assertEquals("0", result);
    }

    @Test
    public void shouldReturnArabicValueForSingleRomanNumber() {
        //given
        RomanNumbers romanNumbers = new RomanNumbers();
        //when
        String result = romanNumbers.convertRomanNumberToArabicNumber("M");
        //then
        assertEquals("1000", result);
    }

    @Test
    public void shouldReturnArabicValueForSortedRomanNumber() {
        //given
        RomanNumbers romanNumbers = new RomanNumbers();
        //when
        String result = romanNumbers.convertRomanNumberToArabicNumber("MDXX");
        //then
        assertEquals("1520", result);
    }

}