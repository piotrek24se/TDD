import java.util.*;

public class RomanNumbers {

    // Jeżeli String (liczba rzymska jest pusta), to zwróć 0.
    // Czy liczba rzymska zawiera wyłącznie cyfry rzymskie (I, V, X, L, C, D, M). Jeżeli nie, to zwróć 0.
    // Jako użytkownik mogę przekonwertować pojedynczą cyfrę rzymską.
    // Jako użytkownik mogę przekonwertować liczbę rzymską, ale z cyframi ułożonymi w kolejności nie rosnącej(np. II, VV, LX, MC, itd.)
    // Jako użytkownik mogę przekonwertować liczbę rzymską z dowolnie ułożonymi cyframi.


    //niedokonczone rozwiazanie (rozwiazanie z zajec - GIT)

    public String convertRomanNumberToArabicNumber(String romanNumber) {
        if (romanNumber.equals(""))
            return "0";

        String[] arrayOfNumbers = romanNumber.split("");

        Map<String, Integer> valuesOfUniqueRomanNumbers = new HashMap<>();

        valuesOfUniqueRomanNumbers.put("I", 1);
        valuesOfUniqueRomanNumbers.put("V", 5);
        valuesOfUniqueRomanNumbers.put("X", 10);
        valuesOfUniqueRomanNumbers.put("L", 50);
        valuesOfUniqueRomanNumbers.put("C", 100);
        valuesOfUniqueRomanNumbers.put("D", 500);
        valuesOfUniqueRomanNumbers.put("M", 1000);

        String one = "I";
        String five = "V";
        String ten = "X";
        String fifty = "L";
        String hundred = "C";
        String fiveHundred = "D";
        String thousand = "M";

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (!arrayOfNumbers[i].equals(one)
                    && !arrayOfNumbers[i].equals(five)
                    && !arrayOfNumbers[i].equals(ten)
                    && !arrayOfNumbers[i].equals(fifty)
                    && !arrayOfNumbers[i].equals(hundred)
                    && !arrayOfNumbers[i].equals(fiveHundred)
                    && !arrayOfNumbers[i].equals(thousand))
                return "0";
        }

        if (arrayOfNumbers.length == 1)
            return convertSingleRomanNumberToArabicNumber(romanNumber);
        else {
            int result = 0;
            for (int i = 1; i < arrayOfNumbers.length; i++) {
                if (valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i]) <= valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i - 1])) {
                    result = result + valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i - 1]);

                } else {
                    result = result + (valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i]) - valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i - 1]));
                    i++;
                }
            }
            if (valuesOfUniqueRomanNumbers.get(arrayOfNumbers[arrayOfNumbers.length - 1]) <= valuesOfUniqueRomanNumbers.get(arrayOfNumbers[arrayOfNumbers.length - 2])) {
                result = result + valuesOfUniqueRomanNumbers.get(arrayOfNumbers[arrayOfNumbers.length - 1]);
            }
            return String.valueOf(result);
        }

    }

    private String convertSingleRomanNumberToArabicNumber(String romanNumber) {
        switch (romanNumber) {
            case ("I"):
                return "1";
            case ("V"):
                return "5";
            case ("X"):
                return "10";
            case ("L"):
                return "50";
            case ("C"):
                return "100";
            case ("D"):
                return "500";
            case ("M"):
                return "1000";
            default:
                return "Wprowadz cyfre rzymska";
        }
    }

}
