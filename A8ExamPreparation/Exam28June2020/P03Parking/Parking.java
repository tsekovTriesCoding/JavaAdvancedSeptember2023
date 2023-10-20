package A8ExamPreparation.Exam28June2020.P03Parking;

import java.util.ArrayList;
import java.util.Collection;

public class Parking {
    private String type;
    private int capacity;
    private Collection<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data
                .stream()
                .reduce((car1, car2) -> car1.getYear() > car2.getYear() ? car1 : car2)
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car c : this.data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                car = c;
                break;
            }
        }

        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type)).append(System.lineSeparator());
        this.data.forEach(car -> sb.append(car).append(System.lineSeparator()));

        return sb.toString();
    }
}
