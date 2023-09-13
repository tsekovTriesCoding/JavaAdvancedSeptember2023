package A5FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<int[], Integer> checkDivision = (arr, number) -> {
            for (int num : arr) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= n; number++) {
            if (checkDivision.test(numbers, number)) {
                System.out.print(number + " ");
            }
        }

    }
}
