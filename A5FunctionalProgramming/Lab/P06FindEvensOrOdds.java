package A5FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(evenOrOdd);

        // 2 вариант :
        //Predicate<Integer> filter = evenOrOdd.equals("even") ? (x -> x % 2 == 0) : (x -> x % 2 != 0);

        // 3 вариант :
//        Predicate<Integer> filter;
//        if (evenOrOdd.equals("even")) {
//            filter = x -> x % 2 == 0;
//        } else if (evenOrOdd.equals("odd")) {
//            filter = x -> x % 2 != 0;
//        }

//        for (int i = lowerBound; i <= upperBound; i++) {
//            if (filter.test(i)) {
//                System.out.print(i + " ");
//            }
//        }

        IntStream.range(lowerBound, upperBound + 1)
                .filter(num -> filter.test(num))
                .forEach(num -> System.out.print(num + " "));
    }

    private static Predicate<Integer> getPredicate(String evenOrOdd) {
        if (evenOrOdd.equals("even")) {
            return x -> x % 2 == 0;
        } else if (evenOrOdd.equals("odd")) {
            return x -> x % 2 != 0;
        }

        throw new RuntimeException("Bad condition! Use even or odd.");
    }
}
