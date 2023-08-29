package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> browsingHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        String currentUrl = "";
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!browsingHistory.isEmpty()) {
                    forwardStack.push(currentUrl);
                    currentUrl = browsingHistory.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = forwardStack.pop();
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    browsingHistory.push(currentUrl);
                }

                currentUrl = command;
                forwardStack.clear();
            }

            System.out.println(currentUrl);
            command = scanner.nextLine();
        }
    }
}
