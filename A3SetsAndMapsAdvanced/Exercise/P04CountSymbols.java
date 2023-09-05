package A3SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> occurrences = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!occurrences.containsKey(symbol)) {
                occurrences.put(symbol, 1);
            } else {
                occurrences.put(symbol, occurrences.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }

    }
}
