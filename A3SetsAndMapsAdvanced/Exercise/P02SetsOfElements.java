package A3SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sizes[0];
        int m = sizes[1];

        Set<String> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String num = scanner.nextLine();
            firstSet.add(num);
        }

        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            String num = scanner.nextLine();
            secondSet.add(num);
        }

        firstSet.retainAll(secondSet);

        System.out.println(String.join(" ", firstSet));
    }
}
