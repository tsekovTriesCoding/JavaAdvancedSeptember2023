package A8ExamPreparation.RetakeExam17Dec2019.P03Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .reduce((present1, present2) -> present1.getWeight() > present2.getWeight() ? present1 : present2)
                .orElse(null);
    }

    public Present getPresent(String name) {
        Present present = null;
        for (Present pr : this.data) {
            if (pr.getName().equals(name)) {
                present = pr;
            }
        }
        return present;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", this.color)).append(System.lineSeparator());
        this.data.forEach(p -> sb.append(p).append(System.lineSeparator()));

        return sb.toString();
    }
}
