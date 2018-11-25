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
        String hunred = "C";
        String fiveHundred = "D";
        String thousand = "M";

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (!arrayOfNumbers[i].equals(one)
                    && !arrayOfNumbers[i].equals(five)
                    && !arrayOfNumbers[i].equals(ten)
                    && !arrayOfNumbers[i].equals(fifty)
                    && !arrayOfNumbers[i].equals(hunred)
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
                    result = result + valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i]) + valuesOfUniqueRomanNumbers.get(arrayOfNumbers[i - 1]);
                    i++;

                } else
                    return "2";
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

//    private String convertSortedRomanNumberToArabicNumberV3 ()

//    private String convertSortedRomanNumberToArabicNumber(String firstNumber, String secondNumber) {
//        int result = 0;
//        if (Integer.valueOf(secondNumber) <= Integer.valueOf(firstNumber)) {
//            result = Integer.valueOf(secondNumber) + Integer.valueOf(secondNumber);
//        }
//        return String.valueOf(result);
//    }

//    private String convertSortedRomanNumberToArabicNumberV2(String[] arrayOfNumbers, String romanNumber) {
//
//        int result = 0;
//
//        //for (int i = 0; i < arrayOfNumbers.length; i++) {
//            if (romanNumber.equals("M")) {
//                result = result + 1000;
//            } else if (romanNumber.equals("D")) {
//                result = result + 500;
//            } else if (romanNumber.equals("C")) {
//                result = result + 100;
//            } else if (romanNumber.equals("L")) {
//                result = result + 50;
//            } else if (romanNumber.equals("X")) {
//                result = result + 10;
//            } else if (romanNumber.equals("V")) {
//                result = result + 5;
//            } else if (romanNumber.equals("I")) {
//                result = result + 1;
//            }
//        //}
//
//        String resultNumber = String.valueOf(result);
//        return resultNumber;
//
//    }


}
