package A6DefiningClasses.Exercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostFor1km;
    private double distanceTraveled;

    public Car(String model, double fuel, double fuelCostFor1km) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public void driveCar(int kmToDrive) {
        if (this.fuelCostFor1km * kmToDrive <= this.fuel) {
            this.fuel -= fuelCostFor1km * kmToDrive;
            this.distanceTraveled += kmToDrive;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }
}
