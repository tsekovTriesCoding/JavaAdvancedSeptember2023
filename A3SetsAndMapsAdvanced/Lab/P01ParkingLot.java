package A3SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carsSet = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if (direction.equals("IN")) {
                carsSet.add(carNumber);
            } else {
                carsSet.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (carsSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String reg : carsSet) {
                System.out.println(reg);
            }
        }
    }
}
