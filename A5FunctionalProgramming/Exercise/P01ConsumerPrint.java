package A5FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        /*Consumer<String> printName = name -> System.out.println(name);

        for (String name : names) {
            printName.accept(name);
        }*/

        Consumer<String[]> printNameFromArr = arr -> {
            for (String name : arr) {
                System.out.println(name);
            }
        };

        printNameFromArr.accept(names);
    }
}
