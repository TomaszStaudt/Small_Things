package pl.staudt.guessTheNumber1.app;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ZgadywanieLiczb {

    public static void main(String[] args) {
        guessTheNumber();
    }

    static void guessTheNumber() {
        Random rand = new Random();
        int askingInt = rand.nextInt(100);
        int yourInt;

        System.out.print("Zgadnij Liczbę (0-100): ");
        for (yourInt = getInt(); yourInt != askingInt; yourInt = getInt()) {
            if (yourInt < askingInt && yourInt != 0) {
                System.out.println("Za mało!");
            } else if (yourInt > askingInt && yourInt != 0) {
                System.out.println("Za dużo!");
            } else if (yourInt <= 0 || yourInt > 100) {
                System.out.println("To nie jest liczba lub nie mieści się w oczekiwanym zakresie.");
            }
        }
        System.out.println("Zgadłeś!");
    }

    static int getInt () {
        Scanner sc = new Scanner(System.in);
        int tempInt;
        try {
            return tempInt = sc.nextInt();
        } catch (InputMismatchException e) {
            return tempInt = 0;
        }
    }
}