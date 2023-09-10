package A5FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peopleWithAge = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            peopleWithAge.putIfAbsent(tokens[0], Integer.valueOf(tokens[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);
        peopleWithAge.entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            return e -> System.out.println(e.getValue());
        } else {
            return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
    }

    private static Predicate<Integer> getPredicate(String condition, int age) {
        if (condition.equals("younger")) {
            return x -> x <= age;
        } else if (condition.equals("older")) {
            return x -> x >= age;
        }

        throw new RuntimeException("Bad condition! Use older or younger.");
    }
}
