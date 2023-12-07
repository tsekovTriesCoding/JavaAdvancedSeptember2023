package Exam;

import java.util.*;

public class P01OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(fuel::push);

        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(consumptionIndex::offer);

        ArrayDeque<Integer> fuelNeeded = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(fuelNeeded::offer);

        int counter = 1;
        boolean notEnoughFuelToReachTop = false;
        List<String> reachedAltitudes = new ArrayList<>();
        while (!fuel.isEmpty() && !consumptionIndex.isEmpty() && !fuelNeeded.isEmpty()) {
            int fuelQuantity = fuel.peek();
            int additionalConsumption = consumptionIndex.peek();
            int neededFuel = fuelNeeded.peek();

            int result = fuelQuantity - additionalConsumption;

            if (result >= neededFuel) {
                fuel.pop();
                consumptionIndex.poll();
                fuelNeeded.poll();
                reachedAltitudes.add("Altitude " + counter);
                System.out.printf("John has reached: Altitude %d%n", counter++);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", counter);
                notEnoughFuelToReachTop = true;
                break;
            }
        }

        if (fuelNeeded.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else if (!reachedAltitudes.isEmpty() && notEnoughFuelToReachTop) {
            System.out.println("John failed to reach the top.");
            System.out.println("Reached altitudes: " + String.join(", ", reachedAltitudes));
        } else if (reachedAltitudes.isEmpty() && notEnoughFuelToReachTop) {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }
    }
}
