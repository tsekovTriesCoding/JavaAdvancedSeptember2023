package A1StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.contains("1")) {
                int x = Integer.parseInt(input.split("\\s+")[1]);

                numbersStack.push(x);
            } else if (input.contains("2")) {
                if (!numbersStack.isEmpty()) {
                    numbersStack.pop();
                }
            } else if (input.contains("3")) {
                System.out.println(Collections.max(numbersStack));
            }
        }
    }
}
