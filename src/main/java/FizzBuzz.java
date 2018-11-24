import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {

    public static void main(String[] args) {

    }

    public String generateSingleSeq(int number) {

        if (number == 0) {
            return String.valueOf(0);
        } else if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else return String.valueOf(number);
    }

    public String generateChain(int number) {

        // 1 sposob

//        String result = "";
//
//        for (int i = 1; i < number + 1; i++) {
//            result += generateSingleSeq(i) + ", ";
//        }

        // 2 sposob

        String result2 = IntStream.range(1, number + 1)
                .mapToObj(s -> generateSingleSeq(s))
                .collect(Collectors.joining(", "));
        return result2;
    }

}
