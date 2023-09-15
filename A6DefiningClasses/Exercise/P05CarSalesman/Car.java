package A6DefiningClasses.Exercise.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb=  new StringBuilder();

        // модел на колата:
        sb.append(this.model).append(":").append(System.lineSeparator());
        //модел на двигателя:
        sb.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        // мощност на двигателя:
        sb.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        //Displacement: engine
        sb.append("Displacement: ");
        if (this.engine.getDisplacement() == 0) {
            //ако не ние подадено:
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        //Efficiency: engine
        sb.append("Efficiency: ");
        if (this.engine.getEfficiency() == null) {
            //ако не ние подадено:
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }
        //Weight: car
        sb.append("Weight: ");
        if (this.weight == 0) {
            //ако не ние подадено:
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }
        //Color: car
        sb.append("Color: ");
        if (this.color == null) {
            //ако не ние подадено:
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
