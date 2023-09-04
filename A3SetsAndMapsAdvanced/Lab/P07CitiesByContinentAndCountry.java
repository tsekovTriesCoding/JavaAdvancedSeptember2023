package A3SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            fillMap(continentsMap, continent, country, city);

        }

        printOutput(continentsMap);
    }

    private static void fillMap(Map<String, Map<String, List<String>>> continentsMap, String continent, String country, String city) {
        continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
        continentsMap.get(continent).putIfAbsent(country, new ArrayList<>());
        continentsMap.get(continent).get(country).add(city);
    }

    private static void printOutput(Map<String, Map<String, List<String>>> continentsMap) {
//        for (Map.Entry<String, Map<String, List<String>>> entry : continentsMap.entrySet()) {
//            System.out.println(entry.getKey() + ":");
//
//            for (Map.Entry<String, List<String>> innerEntry : entry.getValue().entrySet()) {
//                System.out.printf("%s -> %s%n", innerEntry.getKey(), String.join(", ", innerEntry.getValue()));
//            }
//        }

        // Second Variant for printing:
        continentsMap.forEach((continent, countryWithCities) -> {
            System.out.println(continent + ":");

            countryWithCities.forEach((key, value) -> System.out.printf("%s -> %s%n", key, String.join(", ", value)));

        });

    }
}
