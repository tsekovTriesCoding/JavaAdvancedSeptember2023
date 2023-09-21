package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

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

            if (!countriesPopulation.containsKey(country)) {
                countriesPopulation.put(country, new LinkedHashMap<>());
                countriesPopulation.get(country).put(city, population);
                countries.put(country, population);
            } else {
                countriesPopulation.get(country).put(city, population);
                countries.put(country, countries.get(country) + population);
            }

            input = scanner.nextLine();
        }

        countriesPopulation.entrySet().stream().sorted((e1, e2) -> {
                    long pop1 = 0;
                    for (Long value : e1.getValue().values()) {
                        pop1 += value;
                    }
                    long pop2 = 0;
                    for (Long value : e2.getValue().values()) {
                        pop2 += value;
                    }
                    return Long.compare(pop2, pop1);
                })
                .forEach(entry -> {
                    System.out.print(entry.getKey() + " ");

                    StringBuilder builder = new StringBuilder();
                    AtomicLong totalPopulation = new AtomicLong();
                    countriesPopulation.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(e -> {
                                builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                                totalPopulation.addAndGet(e.getValue());
                            });

                    System.out.printf("(total population: %s)%n", totalPopulation);
                    System.out.print(builder);
                });


    }
}
