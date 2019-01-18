package pl.staudt.lotto.app;

import org.apache.commons.lang.ArrayUtils;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SymulatorLotto {

    public static void main (String[] args) {
        lottoSimulator();
    }

    static void lottoSimulator () {
        System.out.println("Wprowadź typowane liczby:");
        StringBuilder sb = new StringBuilder();
        int yourInt;
        int yourIntTab[] = new int[5];

        for (int i = 0; i < yourIntTab.length; ) {
            yourInt = getInt();
            if (yourInt < 1 || yourInt > 49) {
                System.out.println("To nie jest liczba lub nie mieści się w oczekiwanym zakresie.");
            } else if (Arrays.binarySearch(yourIntTab,yourInt) > -1) {
                System.out.println("Taka liczba została już podana");
            } else {
                yourIntTab[0] = yourInt;
                Arrays.sort(yourIntTab);
                i++;
            }
        }
        Arrays.sort(yourIntTab);
        System.out.print("Twoje liczby to: ");
        for (int j = 0; j < yourIntTab.length; j++) {
            System.out.print(yourIntTab[j] + " ");
        }
        System.out.println();
        drawAndCheck(yourIntTab);
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

    static void drawAndCheck (int [] chosenNumbers) {
        Random rand = new Random();
        int[] drawInts = new int [chosenNumbers.length];
        int founds = 0;

        System.out.print("Wylosowane liczby to: ");
        for (int i = 0; i < chosenNumbers.length; i++) {
            drawInts[i] = rand.nextInt(49);
            if ((drawInts[0] == 0) || ArrayUtils.indexOf(drawInts, drawInts[i]) < 0) {
                drawInts[i] += 1;
            }
            System.out.print(drawInts[i] + " ");
            if (Arrays.binarySearch(chosenNumbers,drawInts[i]) > -1) {
                founds++;
            }
        }
        System.out.print("\nIlość trafnych wytypowań: " + founds);
    }
}
