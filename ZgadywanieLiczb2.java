package pl.staudt.guessTheNumber2.app;

import java.util.Random;
import java.util.Scanner;

public class ZgadywanieLiczb2 {

    public static void main(String[] args) {
        guessTheNumber2();
    }

    static void guessTheNumber2() {
        System.out.println("Pomyś liczbę od 0 do 1000, a ja ja zgadnę w maksymalnie 10 próbach.");
        int min = 0;
        int max = 1000;
        int guess;

        String answear;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        guess = rand.nextInt(1000);
        System.out.println("Pobierz odpowiedź z zestawu:\n- za dużo\n- za mało\n- zgadłeś");

        int i = 0;
        do {
            System.out.println("\nzgaduję: " + guess);
            answear = sc.nextLine();
            if (answear.equals("za dużo") && i < 9) {
                max = guess;
                guess = ((max - min) / 2) + min;
                i++;
            } else if (answear.equals("za mało") && i < 9) {
                min = guess;
                guess = ((max - min) / 2) + min;
                i++;
            } else if (!answear.equals("za dużo") && !answear.equals("za mało") && !answear.equals("zgadłeś")) {
                System.err.println("Nie rozumiem tej odpowiedzi :(");
            } else if (i >= 9) {
                System.err.println("Nie oszukuj!");
            }
        }
        while (!answear.equals("zgadłeś"));

        sc.close();
        System.out.println("Wygrałem!");
    }
}
