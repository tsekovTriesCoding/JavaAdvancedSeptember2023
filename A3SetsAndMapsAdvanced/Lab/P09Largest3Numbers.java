package A3SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (sortedNumbers.size() <= 3) {
            sortedNumbers.forEach(e -> System.out.print(e + " "));
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(sortedNumbers.get(i) + " ");
            }
        }
    }
}
