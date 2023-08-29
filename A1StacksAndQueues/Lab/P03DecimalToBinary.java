package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();
        if (number == 0) {
            System.out.println(0);
        }

        while (number != 0) {
            int binaryNum = number % 2;

            binaryStack.push(binaryNum);

            number /= 2;
        }

        while (!binaryStack.isEmpty()) {
            System.out.print(binaryStack.pop());
        }
    }
}
