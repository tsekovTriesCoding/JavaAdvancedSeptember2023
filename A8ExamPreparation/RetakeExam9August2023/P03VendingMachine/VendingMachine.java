package A8ExamPreparation.RetakeExam9August2023.P03VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                this.drinks.remove(drink);
                return true;
            }
        }

        return false;
    }

    public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).get();
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).get();
    }

    public String buyDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                return drink.toString();
            }
        }

        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:").append(System.lineSeparator());
        this.drinks.forEach(drink -> sb.append(drink.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
