package A6DefiningClasses.Exercise.P04RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void isFragile() {
        if (cargo.getType().equals("fragile")) {
            for (Tire tire : tires) {
                if (tire.getPressure() < 1) {
                    System.out.println(this.model);
                    break;
                }
            }
        }
    }

    public void isFlamable() {
        if (cargo.getType().equals("flamable")) {
            if (engine.getEnginePower() > 250) {
                System.out.println(this.model);
            }
        }
    }
}
