package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12Unleashed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> placeWithSinger = new LinkedHashMap<>();
        while (!input.equals("End")) {

            String regex = "(?<name>\\w+\\s*(\\w+)?\\s*(\\w+)?) @(?<venue>\\w+\\s*(\\w+)?\\s*(\\w+)?) (?<price>\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|200)\\b) (?<ticketCount>\\b([0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|[1-9][0-9][0-9][0-9][0-9]|100000)\\b)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            String singer = "";
            String venue = "";
            int ticketsPrice = 0;
            int ticketsCount = 0;
            while (matcher.find()) {
                singer = matcher.group("name");
                venue = matcher.group("venue");
                ticketsPrice = Integer.parseInt(matcher.group("price"));
                ticketsCount = Integer.parseInt(matcher.group("ticketCount"));

                if (!placeWithSinger.containsKey(venue)) {
                    placeWithSinger.put(venue, new LinkedHashMap<>());
                    Map<String, Integer> map = placeWithSinger.get(venue);

                    map.put(singer, ticketsPrice * ticketsCount);
                    placeWithSinger.put(venue, map);

                } else {
                    Map<String, Integer> map = placeWithSinger.get(venue);
                    if (!map.containsKey(singer)) {
                        map.put(singer, ticketsPrice * ticketsCount);
                        placeWithSinger.put(venue, map);
                    } else {
                        map.put(singer, placeWithSinger.get(venue).get(singer) + (ticketsCount * ticketsPrice));
                    }

                }

            }

            input = scanner.nextLine();
        }

        placeWithSinger.forEach((place, v) -> {
            System.out.println(place);

            v.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> {
                        System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
                    });
        });
    }
}
