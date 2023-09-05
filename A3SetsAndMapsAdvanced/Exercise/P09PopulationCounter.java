package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P09PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countriesPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countries = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countriesPopulation.putIfAbsent(country,new LinkedHashMap<>());
            countriesPopulation.get(country).putIfAbsent(city, population);

            countries.put(country,population);

            input = scanner.nextLine();
        }

    }
}
