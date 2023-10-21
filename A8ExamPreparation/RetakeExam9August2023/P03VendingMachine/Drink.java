package A8ExamPreparation.RetakeExam9August2023.P03VendingMachine;

import java.math.BigDecimal;

public class Drink {
    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", " + "Price: " + "$" + this.price + ", " + "Volume: " + this.volume + " ml";
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
