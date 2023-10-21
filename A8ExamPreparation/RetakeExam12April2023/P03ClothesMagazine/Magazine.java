package A8ExamPreparation.RetakeExam12April2023.P03ClothesMagazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return this.data.removeIf(c -> c.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return this.data.stream().min(Comparator.comparingInt(Cloth::getSize)).get();
    }

    public Cloth getCloth(String color) {
        return this.data.stream().filter(c -> c.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s magazine contains:", this.type)).append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c).append(System.lineSeparator()));

        return sb.toString().trim();
    }


}
