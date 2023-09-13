package A6DefiningClasses.Lab.P02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String brand;
            String model;
            int horsePower;
            if (tokens.length == 1) {
                brand = tokens[0];

                Car car = new Car(brand);
                carsList.add(car);
            } else {
                brand = tokens[0];
                model = tokens[1];
                horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(brand, model, horsePower);
                carsList.add(car);
            }

        }

        carsList.forEach(car -> System.out.println(car));
    }
}
