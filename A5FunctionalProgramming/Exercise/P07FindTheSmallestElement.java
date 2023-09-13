package A5FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 1 начин - директно отпечатваме с Consumer:
        // Consumer<List<Integer>> printLastIndexOfMinElement = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        // printLastIndexOfMinElement.accept(numbers);

        // 2 начин - връщаме полседния индекс на най-малкия елемент:
        Function<List<Integer>, Integer> getLastIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        int lastIndexOfMinElement = getLastIndexOfMinElement.apply(numbers);

        System.out.println(lastIndexOfMinElement);
    }
}
