package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P07HandsOfCards {

    private static Map<String, Integer> multipliers = new HashMap<>();

    private static Map<String, Integer> powers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        multipliers.put("S", 4);
        multipliers.put("H", 3);
        multipliers.put("D", 2);
        multipliers.put("C", 1);

        powers.put("2", 2);
        powers.put("3", 3);
        powers.put("4", 4);
        powers.put("5", 5);
        powers.put("6", 6);
        powers.put("7", 7);
        powers.put("8", 8);
        powers.put("9", 9);
        powers.put("10", 10);
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];

            if (!players.containsKey(name)) {
                players.put(name, new LinkedHashSet<>());
            }

            String[] cards = tokens[1].split(", ");

            for (String card : cards) {
                players.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        players.forEach((k, v) -> {
            int points = calculatePoints(v);

            System.out.printf("%s: %s%n", k, points);
        });
    }

    private static int calculatePoints(Set<String> cards) {

        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String multiplier = card.substring(card.length() - 1);

            points += powers.get(power) * multipliers.get(multiplier);
        }

        return points;
    }
}
