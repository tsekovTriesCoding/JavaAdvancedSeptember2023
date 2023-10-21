package A8ExamPreparation.RegularExam17June2023.P03AutomotiveRepairShop;

public class Vehicle {
    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)", this.damage, this.VIN, this.mileage);
    }

    public String getVIN() {
        return VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDamage() {
        return damage;
    }
}
