package A5FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 1 начин - без фунционално програмиране:
        // System.out.println(Collections.min(numbers));

        // 2 начин :
        // Consumer<List<Integer>> printMinNum = list -> System.out.println(Collections.min(list));
        // printMinNum.accept(numbers);

        // 3 начин :
        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);

        System.out.println(getMinNumber.apply(numbers));
    }
}
