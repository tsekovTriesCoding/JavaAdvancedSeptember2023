package A6DefiningClasses.Exercise.P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            pokemonByTrainers.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainers.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainers = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String element = input;
            for (Trainer trainer : trainers) {
                trainer.checkElement(element);
            }

            input = scanner.nextLine();
        }

        trainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}
