package A5FunctionalProgramming.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        printNumbers(numbers);
        Collections.sort(numbers);
        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        List<String> numbersAsString = new ArrayList<>();

        for (Integer number : numbers) {
            numbersAsString.add(String.valueOf(number));
        }

        System.out.println(String.join(", ", numbersAsString));
    }

}
