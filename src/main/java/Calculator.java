import java.math.BigDecimal;

public class Calculator {

    public static String add(String first, String second) {
        BigDecimal firstNumber = new BigDecimal(first);
        BigDecimal secondNumber = new BigDecimal(second);

        // na zajeciach zmieniono zaokraglanie (porownac z git/slack)
        return firstNumber.add(secondNumber).toPlainString();
    }

    public static void main(String[] args) {
        System.out.println(add("1", "2"));
    }

}
