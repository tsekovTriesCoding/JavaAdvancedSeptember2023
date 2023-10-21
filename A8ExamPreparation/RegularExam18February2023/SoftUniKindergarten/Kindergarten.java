package A8ExamPreparation.RegularExam18February2023.SoftUniKindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }

        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                this.registry.remove(child);
                return true;
            }
        }

        return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }

        return null;
    }

    public String registryReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("Registered children in ").append(this.name).append(":").append(System.lineSeparator());

        this.registry.stream().sorted(Comparator.comparingInt(Child::getAge)
                        .thenComparing(Comparator.comparing(Child::getFirstName)
                                .thenComparing(Child::getLastName)))
                .forEach(child -> sb.append("--").append(System.lineSeparator()).append(child).append(System.lineSeparator()));

        return sb.toString();
    }
}
