package A8ExamPreparation.RegularExam19February2022.P03Parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",this.species, this.name);
    }


}
