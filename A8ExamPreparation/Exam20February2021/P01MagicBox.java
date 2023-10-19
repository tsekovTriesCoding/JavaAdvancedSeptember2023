package A8ExamPreparation.Exam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstMagicBox::offer);

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondMagicBox::push);

        int sumOfItems = 0;
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int firstBoxItem = firstMagicBox.peek();
            int secondBoxItem = secondMagicBox.peek();

            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                sumOfItems += sum;
                firstMagicBox.poll();
                secondMagicBox.pop();
            } else {
                firstMagicBox.addLast(secondMagicBox.pop());
            }

        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (sumOfItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", sumOfItems);
        } else {
            System.out.printf("Poor prey... Value: %d", sumOfItems);
        }


    }
}
