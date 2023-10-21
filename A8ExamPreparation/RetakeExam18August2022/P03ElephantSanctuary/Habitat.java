package A8ExamPreparation.RetakeExam18August2022.P03ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : this.data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }

        return null;
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparingInt(Elephant::getAge)).get();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(e -> sb.append(e.getName()).append(" ").append("came from: ")
                .append(e.getRetiredFrom()).append(System.lineSeparator()));

        return sb.toString();
    }
}
