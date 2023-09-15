package A6DefiningClasses.Exercise.P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.collectionOfPokemon = pokemons;
        this.numberOfBadges = 0;
    }


    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void checkElement(String element) {
        boolean match = false;
        for (Pokemon pokemon : this.collectionOfPokemon) {
            if (element.equals(pokemon.getElement())) {
                match = true;
                break;
            }
        }

        if (match) {
            this.numberOfBadges++;
        } else {
            for (int i = 0; i < this.collectionOfPokemon.size(); i++) {
                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                checkPokemonHealth();
            }
        }
    }

    public void checkPokemonHealth() {
        for (int i = 0; i < this.collectionOfPokemon.size(); i++) {
            if (collectionOfPokemon.get(i).getHealth() <= 0) {
                this.collectionOfPokemon.remove(collectionOfPokemon.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.numberOfBadges, this.collectionOfPokemon.size());
    }
}
