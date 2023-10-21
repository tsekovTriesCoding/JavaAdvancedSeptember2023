package A8ExamPreparation.RetakeExam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licencePlates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(licencePlates::offer);

        ArrayDeque<Integer> cars = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(cars::push);

        int days = 0;
        int registeredCars = 0;
        while (!licencePlates.isEmpty() && !cars.isEmpty()) {
            int currentPlates = licencePlates.poll();
            int currentCars = cars.pop();
            days++;

            if (currentPlates / 2 == currentCars) {
                registeredCars += currentCars;
            } else if (currentPlates / 2 < currentCars) {
                registeredCars += currentPlates / 2;
                cars.addLast(currentCars - currentPlates / 2);
            } else {
                registeredCars += currentCars;
                licencePlates.addLast(currentPlates - currentCars * 2);
            }

        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (licencePlates.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!licencePlates.isEmpty()) {
            int count = 0;
            for (Integer licencePlate : licencePlates) {
                count += licencePlate;
            }

            System.out.printf("%d license plates remain!%n", count);
        } else {
            int count = 0;
            for (Integer car : cars) {
                count += car;
            }
            System.out.printf("%d cars remain without license plates!%n", count);
        }


    }
}
