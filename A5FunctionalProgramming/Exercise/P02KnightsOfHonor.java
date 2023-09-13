package A5FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        /*Consumer<String[]> printNameFromArr = arr -> {
            for (String name : arr) {
                System.out.println("Sir " + name);
            }
        };

        printNameFromArr.accept(names);*/

        Consumer<String> printName = name -> System.out.println("Sir " + name);

        Arrays.stream(names).forEach(printName);

    }
}
