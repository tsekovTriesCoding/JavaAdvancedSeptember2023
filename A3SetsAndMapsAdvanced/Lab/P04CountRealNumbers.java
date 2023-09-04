package A3SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        double[] numbers = readArray(scanner);
//
        Map<Double, Integer> numbersCount = new LinkedHashMap<>();
//
//        for (double num : numbers) {
//            if (!numbersCount.containsKey(num)) {
//                numbersCount.put(num, 1);
//            } else {
//                numbersCount.put(num, numbersCount.get(num) + 1);
//            }
//        }

        // second Variant: with stream
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(e -> {
                    if (!numbersCount.containsKey(e)) {
                        numbersCount.put(e, 1);
                    } else {
                        numbersCount.put(e, numbersCount.get(e) + 1);
                    }
                });

        numbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }

//    private static double[] readArray(Scanner scanner) {
//
//        return Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToDouble(Double::parseDouble)
//                .toArray();
//    }
}
