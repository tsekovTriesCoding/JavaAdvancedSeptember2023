package A8ExamPreparation.RetakeExam18August2022.P03ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                this.data.remove(animal);
                return true;
            }
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }

        return null;
    }

    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparingInt(Animal::getAge)).get();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(animal -> sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator()));

        return sb.toString();
    }
}
