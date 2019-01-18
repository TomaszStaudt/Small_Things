package dice;

import java.util.Random;
import java.util.Scanner;

public class KostkaDoGry {
    public static void main (String[] args) {
        Dice(getCode());
    }

    static void Dice(String code) {
        if (regexMatch(code)) {
            String[] decodedTab = code.split("[D]|[+]|[-]");
            int isMinusOrPlus = code.indexOf('-') < 0 ? (code.indexOf('+') > 0 ? 1 : 0) : -1;
            int howManyThrows = decodedTab[0].equals("") ? 1 : Integer.parseInt(decodedTab[0]);
            int diceDimension = Integer.parseInt(decodedTab[1]);
            int modificator = tabLenght(decodedTab) == 2 ? 0 : Integer.parseInt(decodedTab[2]);
            int result = howManyThrows * drawTheDice(diceDimension) + (modificator * isMinusOrPlus);
            System.out.println(result < 0 ? 0 : result);
        } else {
            System.out.println("Podano błędny kod kości do gry");
        }
    }

    static int drawTheDice (int dimension) {
        Random rand = new Random();
        int draw = rand.nextInt(dimension);
        return draw == 0 ? draw + 1 : draw;
    }

    static int tabLenght (String[] tab) {
        return tab.length;
    }

    static boolean regexMatch(String code) {
        return code.matches("(.*)[D]{1}(.*)");
        //regex do dopracowania
    }

    static String getCode() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
}
