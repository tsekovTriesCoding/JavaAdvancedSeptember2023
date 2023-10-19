package A8ExamPreparation.RetakeExam19August2020.P03VetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = p;
            }
        }
        return pet;
    }

    public Pet getOldestPet() {
        return this.data
                .stream()
                .reduce((pet1, pet2) -> pet1.getAge() > pet2.getAge() ? pet1 : pet2)
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        this.data.forEach(pet -> sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator()));

        return sb.toString();
    }

}
