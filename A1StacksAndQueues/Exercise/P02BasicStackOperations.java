package A1StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(numbersStack::push);

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
        } else if (numbersStack.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(numbersStack));
        }

    }
}
