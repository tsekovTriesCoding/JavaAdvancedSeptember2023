package A6DefiningClasses.Exercise.P09CatLady;

public class Cat {
    private String name;
    private String breed;
    private double breedInfo;

    public Cat(String name, String breed, double breedInfo) {
        this.name = name;
        this.breed = breed;
        this.breedInfo = breedInfo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.breedInfo);
    }
}
