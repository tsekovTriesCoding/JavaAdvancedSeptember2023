package A8ExamPreparation.RetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (isLessOrEqualToZero(males, females, male, female)) continue;

            if (male % 25 == 0 || female % 25 == 0) {
                if (isDivisibleBy25WithoutReminder(males, male)) break;
                if (isDivisibleBy25WithoutReminder(females, female)) break;
                continue;
            }

            if (male == female) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                males.push(males.pop() - 2);
            }

        }

        System.out.printf("Matches: %d%n", matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(males.toString().replaceAll("[\\[\\]]", ""));
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(females.toString().replaceAll("[\\[\\]]", ""));
        }


    }

    private static boolean isDivisibleBy25WithoutReminder(ArrayDeque<Integer> males, int male) {
        if (male % 25 == 0) {
            if (males.contains(male)) {
                males.pop();
                males.pop();

            } else {
                males.pop();
            }
        }
        if (males.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isLessOrEqualToZero(ArrayDeque<Integer> males, ArrayDeque<Integer> females, int male, int female) {
        if (male <= 0 || female <= 0) {
            if (male <= 0) {
                males.pop();
            }
            if (female <= 0) {
                females.poll();
            }
            return true;
        }
        return false;
    }
}
