package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> openIndexes = new ArrayDeque<>();

        for (int i = 0; i <= input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                openIndexes.push(i);
            } else if (currentSymbol == ')') {
                int lastOpenIndex = openIndexes.pop();
                String substring = input.substring(lastOpenIndex, i + 1);

                System.out.println(substring);
            }
        }


    }
}
