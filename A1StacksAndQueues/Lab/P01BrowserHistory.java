package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> browsingHistory = new ArrayDeque<>();
        String currentUrl = "";
        while (!command.equals("Home")) {

            if (!command.equals("back")) {
                if (!currentUrl.isEmpty()) {
                    browsingHistory.push(currentUrl);
                }

                currentUrl = command;
            } else {
                if (!browsingHistory.isEmpty()) {
                    currentUrl = browsingHistory.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            }

            System.out.println(currentUrl);
            command = scanner.nextLine();
        }
    }
}
