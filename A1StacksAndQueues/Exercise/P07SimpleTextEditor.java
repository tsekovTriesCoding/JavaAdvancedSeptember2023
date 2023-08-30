package A1StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> commands = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] tokens = rawCommand.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "1":
                    commands.push(rawCommand);
                    String string = tokens[1];
                    sb.append(string);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int count = Integer.parseInt(tokens[1]);
                    saveRemovedElements(sb, count, removedElements);
                    eraseElement(sb, count);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    tokens = lastCommand.split("\\s+");
                    command = tokens[0];

                    if (command.equals("1")) {
                        int numberOfElementsToErase = tokens[1].length();
                        eraseElement(sb, numberOfElementsToErase);
                    } else if (command.equals("2")) {
                        sb.append(removedElements.pop());
                    }
                    break;
            }
        }
    }

    private static void saveRemovedElements(StringBuilder sb, int count, ArrayDeque<String> removedElements) {
        StringBuilder deletedElements = new StringBuilder();

        for (int i = sb.length() - count; i < sb.length(); i++) {
            deletedElements.append(sb.charAt(i));
        }
        removedElements.push(deletedElements.toString());
    }

    private static void eraseElement(StringBuilder sb, int count) {
        int length = sb.length();

        for (int i = 1; i <= count; i++) {
            sb.deleteCharAt(length - i);
        }
    }
}
