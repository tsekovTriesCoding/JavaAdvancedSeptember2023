package A8ExamPreparation.RegularExam17June2023.P03AutomotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                this.vehicles.remove(vehicle);
                return true;
            }
        }

        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).get();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        this.vehicles.forEach(vehicle -> sb.append(vehicle).append(System.lineSeparator()));

        return sb.toString();
    }
}
