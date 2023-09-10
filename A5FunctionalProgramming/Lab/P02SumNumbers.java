package A5FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> sumOfElementsInList = list -> {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            return sum;
        };

        int sum = sumOfElementsInList.apply(numbers);
        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
