import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PeselTest {

    //getGenderByPesel

    @Test
    public void shouldReturnTrueIfPeselIsTrue() {
        //given
        Pesel pesel = new Pesel();
        //when
        boolean isTrue = pesel.isValidPesel("91061014659");
        //then
        assertEquals(true, isTrue);
    }

    @Test
    public void shouldReturnFalseIfPeselIsFalse() {
        //given
        Pesel pesel = new Pesel();
        //when
        boolean isTrue = pesel.isValidPesel("91061014658");
        //then
        assertEquals(false, isTrue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"91061014658355335", "5545"})
    public void shouldReturnFalseIfPeselLengthIsGreaterOrShorterThan11(String param) {
        //given
        Pesel pesel = new Pesel();
        //when
        boolean isTrue = pesel.isValidPesel(param);
        //then
        assertEquals(false, isTrue);
    }

    //getGenderByPesel

    @Test
    public void shouldReturnWomanIf9ElementIsDivideByZero() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getGenderByPesel("75082857821");
        //then
        assertEquals("woman", result);
    }

    @Test
    public void shouldReturnManIf9ElementIsNotDivideByZero() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getGenderByPesel("91061014659");
        //then
        assertEquals("man", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"91061014658355335", "5545"})
    public void shouldReturnFalseIfPeselLengthIsGreaterOrShorterThan11V2(String param) {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getGenderByPesel(param);
        //then
        assertEquals("Nieprawidlowa liczba znakow. Wprowadz nr PESEL o dlugosci 11 znakow", result);
    }

    //getDateOfBirth

    @Test
    public void shouldReturn10061991IfPeselStartsWith910610() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth("91061014659");
        //then
        assertEquals("Date of birth: 10.06.1991", result);
    }

    @Test
    public void shouldReturn10061891IfPeselStartsWith918610() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth("91861014659");
        //then
        assertEquals("Date of birth: 10.06.1891", result);
    }

    @Test
    public void shouldReturn10062091IfPeselStartsWith912610() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth("91261014659");
        //then
        assertEquals("Date of birth: 10.06.2091", result);
    }

    @Test
    public void shouldReturn10062191IfPeselStartsWith914610() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth("91461014659");
        //then
        assertEquals("Date of birth: 10.06.2191", result);
    }

    @Test
    public void shouldReturn10062291IfPeselStartsWith916610() {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth("91661014659");
        //then
        assertEquals("Date of birth: 10.06.2291", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"91061014658355335", "5545"})
    public void shouldReturnFalseIfPeselLengthIsGreaterOrShorterThan11V3(String param) {
        //given
        Pesel pesel = new Pesel();
        //when
        String result = pesel.getDateOfBirth(param);
        //then
        assertEquals("Nieprawidlowa liczba znakow. Wprowadz nr PESEL o dlugosci 11 znakow", result);
    }
}