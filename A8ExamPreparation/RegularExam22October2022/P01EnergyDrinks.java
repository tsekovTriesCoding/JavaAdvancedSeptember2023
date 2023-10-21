package A8ExamPreparation.RegularExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeineMilligrams = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(caffeineMilligrams::push);

        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int totalCaffeine = 0;
        while (!caffeineMilligrams.isEmpty() && !energyDrinks.isEmpty()) {
            int caffeine = caffeineMilligrams.peek() * energyDrinks.peek();

            if (caffeine + totalCaffeine <= 300) {
                caffeineMilligrams.pop();
                energyDrinks.poll();
                totalCaffeine += caffeine;
            } else {
                totalCaffeine -= 30;
                caffeineMilligrams.pop();
                energyDrinks.addLast(energyDrinks.poll());
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }
            }
        }

        if (!energyDrinks.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinks.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);

    }
}
