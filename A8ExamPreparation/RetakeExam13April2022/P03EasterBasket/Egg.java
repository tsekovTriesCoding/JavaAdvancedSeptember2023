package A8ExamPreparation.RetakeExam13April2022.P03EasterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.", this.color, this.strength, this.shape);
    }

    public String getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

    public String getShape() {
        return shape;
    }
}
