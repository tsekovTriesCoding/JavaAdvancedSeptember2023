package A3SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");

            String name = tokens[0];
            String number = tokens[1];

            phonebook.putIfAbsent(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            input = scanner.nextLine();
        }
    }
}
