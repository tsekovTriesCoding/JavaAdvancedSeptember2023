package A8ExamPreparation.RetakeExam15December2021.P03WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        boolean noSameName = true;
        for (Fish f : this.fishInPool) {
            if (f.getName().equals(fish.getName())) {
                noSameName = false;
                break;
            }
        }
        if (this.fishInPool.size() < this.capacity && noSameName) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }

        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append(System.lineSeparator());
        this.fishInPool.forEach(fish -> sb.append(fish).append(System.lineSeparator()));

        return sb.toString();
    }

}
