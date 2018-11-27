import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FizzBuzzTest {

    @Test
    public void shouldReturn0IfNumberIs0() {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when
        String result = fizzBuzz.generateSingleSeq(0);
        //then
        assertEquals(String.valueOf(0), result);
    }

    @Test
    public void shouldReturnFizzIfNumberIs3() {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when
        String result = fizzBuzz.generateSingleSeq(3);
        //then
        assertEquals("Fizz", result);
    }

    // metoda parametryzowana

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 50})
    public void shouldReturnBuzzIfNumberIs5(int param) {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedSeq = "Buzz";
        //when
        String result = fizzBuzz.generateSingleSeq(param);
        //then
        assertEquals(expectedSeq, result);
    }

    @Test
    public void shouldReturnFizzBuzzIfNumberIs15() {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when
        String result = fizzBuzz.generateSingleSeq(15);
        //then
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void shouldReturn2IfNumberIs2() {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when
        String result = fizzBuzz.generateSingleSeq(2);
        //then
        assertEquals(String.valueOf(2), result);
    }

    @Test
    public void shouldReturnChainIfNumberIs16() {
        //given
        FizzBuzz fizzBuzz = new FizzBuzz();
        //when
        String result = fizzBuzz.generateChain(16);
        //then

        // 1 sposob
        // assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, ", result);

        // 2 sposob
         assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16", result);
    }


}