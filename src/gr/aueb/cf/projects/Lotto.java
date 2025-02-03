package gr.aueb.cf.projects;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Το πρόγραμμα διαβάζει ακέραιους αριθμούς από ένα αρχείο, παράγει όλες τις δυνατές εξάδες από αυτούς τους αριθμούς,
 * και φιλτράρει αυτές τις εξάδες με βάση διάφορους περιορισμούς. Στη συνέχεια, οι εξάδες που πληρούν τα κριτήρια
 * εκτυπώνονται σε ένα αρχείο εξόδου και στην κονσόλα.
 *
 */


public class Lotto {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("C:/tmp/lotto5in.txt"));
             PrintStream ps = new PrintStream("C:/tmp/lotto5out.txt", StandardCharsets.UTF_8)) {

            final int LOTTO_SIZE = 6; // Ο αριθμός των αριθμών σε κάθε εξάδα
            int[] inputNumbers = new int[49]; // Πίνακας για τους αριθμούς που διαβάζονται από το αρχείο
            int pivot = 0; // Δείκτης για την τοποθέτηση των αριθμών στον πίνακα
            int[] result = new int[LOTTO_SIZE];
            int num;
            int window;

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumbers[pivot++] = num;
            }

            // Κόβουμε τον πίνακα μέχρι την πραγματική θέση του τελευταίου αριθμού
            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - LOTTO_SIZE;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];

                                    // Έλεγχος των περιορισμών που έχουν τεθεί

                                    if (!isEven(result, 4) && !isOdd(result, 4) && !consecutive(result)
                                            && !sameEnding(result, 3) && !sameTen(result, 3)) {
                                        ps.printf("%d %d %d %d %d %d\n",
                                                result[0], result[1], result[2], result[3], result[4], result[5]);
                                        System.out.printf("%d %d %d %d %d %d\n",
                                                result[0], result[1], result[2], result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ελέγχει αν ο αριθμός των άρτιων αριθμών σε μια εξάδα είναι μικρότερος ή ίσος με το όριο.
     *
     */

    public static boolean isEven(int[] arr, int threshold) {
        long evenCount = Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .count();

        return evenCount <= threshold;
    }

    /**
     * Ελέγχει αν ο αριθμός των περιττών αριθμών σε μια εξάδα είναι μικρότερος ή ίσος με το όριο.
     *
     */

    public static boolean isOdd(int[] arr, int threshold) {
        long oddCount = Arrays.stream(arr)
                .filter(num -> num % 2 != 0)
                .count();

        return oddCount <= threshold;
    }

    /**
     * Ελέγχει αν υπάρχουν τουλάχιστον 3 συνεχόμενοι αριθμοί στην εξάδα.
     *
     */

    public static boolean consecutive(int[] arr) {
        for (int i = 0; i <= 3; i++) {
            if (arr[i] == arr[i + 1] - 1 && arr[i + 1] == arr[i + 2] - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ελέγχει αν τουλάχιστον 3 αριθμοί στην εξάδα έχουν το ίδιο τελευταίο ψηφίο.
     *
     */

    public static boolean sameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];

        for (int num : arr) {
            endings[num % 10]++;
        }

        return Arrays.stream(endings).anyMatch(e -> e >= threshold);
    }

    /**
     * Ελέγχει αν τουλάχιστον 3 αριθμοί στην εξάδα ανήκουν στην ίδια δεκάδα.
     *
     */

    public static boolean sameTen(int[] arr, int threshold) {
        int[] ten = new int[5];

        for (int num : arr) {
            ten[num / 10]++;
        }

        return Arrays.stream(ten).anyMatch(t -> t >= threshold);
    }
}