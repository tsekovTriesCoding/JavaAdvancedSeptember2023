package A8ExamPreparation.Exam20February2021.P03CarDealership;

import java.util.ArrayList;
import java.util.Collection;

public class Dealership {
    public String name;
    public int capacity;
    private Collection<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.isEmpty()) {
            return null;
        }

        int year = 0;
        Car carToReturn = null;
        for (Car car : this.data) {
            if (car.getYear() > year) {
                year = car.getYear();
                carToReturn = car;
            }
        }

        return carToReturn;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }

        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The cars are in a car dealership %s:", this.name)).append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c).append(System.lineSeparator()));

        return sb.toString();
    }


}
