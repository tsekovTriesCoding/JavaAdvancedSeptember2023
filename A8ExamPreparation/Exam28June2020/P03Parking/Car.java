package A8ExamPreparation.Exam28June2020.P03Parking;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }
}
