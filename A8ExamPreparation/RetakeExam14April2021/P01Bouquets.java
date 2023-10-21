package A8ExamPreparation.RetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        int bouquets = 0;
        int storedFlowers = 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int daffodil = daffodils.poll();
            int tulip = tulips.pop();
            int sum = daffodil + tulip;

            if (sum == 15) {
                bouquets++;
            } else if (sum > 15) {
                while (sum > 15) {
                    tulip -= 2;
                    sum = tulip + daffodil;
                }

                if (sum == 15) {
                    bouquets++;
                } else {
                    storedFlowers += sum;
                }
            } else {
                storedFlowers += sum;

            }

        }

        if (storedFlowers >= 15) {
            bouquets += storedFlowers / 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
