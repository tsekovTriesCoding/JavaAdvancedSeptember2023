package A6DefiningClasses.Exercise.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCostFor1km = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            carsMap.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(input.split("\\s+")[2]);

            if (carsMap.containsKey(model)) {
                carsMap.get(model).driveCar(kmToDrive);
            }
            input = scanner.nextLine();
        }

        carsMap.values().forEach(car -> {
            System.out.printf("%s %.2f %.0f%n", car.getModel(), car.getFuel(), car.getDistanceTraveled());
        });
    }
}
