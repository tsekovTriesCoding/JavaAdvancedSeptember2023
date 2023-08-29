package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> fileNamesQueue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                fileNamesQueue.offer(input);
            } else {
                if (!fileNamesQueue.isEmpty()) {
                    System.out.println("Canceled " + fileNamesQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            input = scanner.nextLine();
        }

        while (!fileNamesQueue.isEmpty()) {
            System.out.println(fileNamesQueue.pop());
        }
    }
}
