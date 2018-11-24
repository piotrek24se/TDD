public class Pesel {

    public static void main(String[] args) {

        String pesel = "91061014659";


    }


    public boolean isValidPesel(String pesel) {

        if (pesel.length() == 11) {
            String[] str = pesel.split("");
            int[] ints = new int[pesel.length()];

            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.valueOf(str[i]);
            }

            int sum = 9 * ints[0] + 7 * ints[1] + 3 * ints[2] + 1 * ints[3] + 9 * ints[4] + 7 * ints[5] + 3 * ints[6] + 1 * ints[7] + 9 * ints[8] + 7 * ints[9];
            System.out.println("Suma: " + sum);

            int mod = sum % 10;
            System.out.println("Modulo: " + mod);

            if (ints[ints.length - 1] == mod) {
                return true;
            } else return false;
        } else return false;
    }

    public String getGenderByPesel(String pesel) {

        if (pesel.length() == 11) {
            String[] str = pesel.split("");
            int[] ints = new int[pesel.length()];

            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.valueOf(str[i]);
            }

            if (ints[9] % 2 == 0) {
                return "woman";
            } else return "man";
        } else return "Nieprawidlowa liczba znakow. Wprowadz nr PESEL o dlugosci 11 znakow";
    }

    public String getDateOfBirth(String pesel) {
        if (pesel.length() == 11) {
            String[] str = pesel.split("");
            int[] ints = new int[pesel.length()];

            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.valueOf(str[i]);
            }

            if (ints[2] <= 1) {
                return "Date of birth: " + ints[4] + ints[5] + "." + ints[2] + ints[3] + "." + "19" + ints[0] + ints[1];
            } else if (ints[2] == 9 || ints[2] == 8) {
                return "Date of birth: " + ints[4] + ints[5] + "." + (ints[2] - 8) + ints[3] + "." + "18" + ints[0] + ints[1];
            } else if (ints[2] == 3 || ints[2] == 2) {
                return "Date of birth: " + ints[4] + ints[5] + "." + (ints[2] - 2) + ints[3] + "." + "20" + ints[0] + ints[1];
            } else if (ints[2] == 5 || ints[2] == 4) {
                return "Date of birth: " + ints[4] + ints[5] + "." + (ints[2] - 4) + ints[3] + "." + "21" + ints[0] + ints[1];
            } else if (ints[2] == 7 || ints[2] == 6) {
                return "Date of birth: " + ints[4] + ints[5] + "." + (ints[2] - 6) + ints[3] + "." + "22" + ints[0] + ints[1];
            } else return "Dane spoza zakresu";
        } else return "Nieprawidlowa liczba znakow. Wprowadz nr PESEL o dlugosci 11 znakow";
    }
}
