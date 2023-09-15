package A6DefiningClasses.Exercise.P04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);

            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);

            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);

            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            List<Tire> tires = new ArrayList<>(Arrays.asList(tire1, tire2, tire3, tire4));

            Car car = new Car(model, engine, cargo, tires);
            cars.put(model, car);
        }

        String type = scanner.nextLine();

        switch (type) {
            case "fragile":
                cars.values().forEach(car -> {
                    car.isFragile();
                });
                break;
            case "flamable":
                cars.values().forEach(car -> {
                    car.isFlamable();
                });
                break;
        }
    }
}
