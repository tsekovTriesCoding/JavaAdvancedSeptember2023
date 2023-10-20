package A8ExamPreparation.RetakeExam13April2022.P03EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }

        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparingInt(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }

        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.material).append(" basket contains:").append(System.lineSeparator());
        this.data.forEach(egg -> sb.append(egg).append(System.lineSeparator()));
        return sb.toString().trim();
    }

}
