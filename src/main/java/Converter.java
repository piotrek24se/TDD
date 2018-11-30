import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static final Map<Character, Integer> romanNumbers = new HashMap<>();

    public Converter() {
        romanNumbers.put('I', 1); //Mapa z parami cyfra rzymska - jej wartość arabska
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);
    }

    public int roman2arabic(String inputNumber) {
        if (!isValid(inputNumber)) //Sprawdzam czy podana liczba rzymska jest poprawna
            return 0;

        char[] romanInputChars = inputNumber.toCharArray(); //Konwertuję liczbę rzymską to zabliczy pojedynczych cyfr

        int i = 0; //Licznik do przechodzenia po tablicy z cyframi arabskimi
        int sum = 0; //Obliczona liczba arabska, na początku zero

        while (i < romanInputChars.length) {
            if (i == romanInputChars.length - 1) {
                sum += romanNumbers.get(romanInputChars[i]);
                i++;
            } else {
                int firstNumber = romanNumbers.get(romanInputChars[i]); //Konwertuj cyfrę rzymską do arabskiej
                int secondNumber = romanNumbers.get(romanInputChars[i + 1]); //Konwertuj cyfrę rzymską do arabskiej

                if (firstNumber < secondNumber) { //Jeżeli pierwsza cyfra jest mniejsza od drugiej, np. 'IV'
                    sum += secondNumber - firstNumber; //Dla cyfr w kolejnośc mniejsza, większa odejmujemy od większej mniejszą
                    i += 2; //Dla cyfr w kolejności mniejsza, większa przechodzi nie do następnej cyfry, a dwie dalej
                } else { //Jeżeli pierwsza cyfra jest większa bądź równa drugiej, np. VI, lub VV
                    sum += firstNumber;
                    i++;
                }
            }
        }
        return sum;
    }

    private boolean isValid(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) //Podan liczba nie może być ani nullem, ani pusta
            return false;

        for (int i = 0; i < inputNumber.length(); i++) {
            if (!romanNumbers.containsKey(inputNumber.charAt(i))) //Każdy ze znaków musi być cyfrą rzymską
                return false;
        }

        return true;
    }
}