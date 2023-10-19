package A8ExamPreparation.RetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);

        int wreaths = 0;
        int storedFlowers = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lily = lilies.pop();
            int rose = roses.poll();
            int sum = lily + rose;

            if (sum > 15) {
                while (sum > 15) {
                    lily -= 2;
                    sum = lily + rose;
                }

            }

            if (sum == 15) {
                wreaths++;
            } else {
                storedFlowers += sum;
            }

        }

        if (storedFlowers > 0) {
            wreaths += storedFlowers / 15;
        }

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
