package A6DefiningClasses.Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCount = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < enginesCount; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            int enginePower = Integer.parseInt(engineInfo[1]);
            int displacement = 0;
            String efficiency = null;

            if (engineInfo.length == 3) {
                if (Character.isDigit(engineInfo[2].charAt(0))) {
                    displacement = Integer.parseInt(engineInfo[2]);
                } else {
                    efficiency = engineInfo[2];
                }
            } else if (engineInfo.length == 4) {
                displacement = Integer.parseInt(engineInfo[2]);
                efficiency = engineInfo[3];
            }

            Engine engine = new Engine(model, enginePower, displacement, efficiency);
            engines.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];
            String engineModel = carInfo[1];
            int weight = 0;
            String color = null;
            if (carInfo.length == 4) {
                weight = Integer.parseInt(carInfo[2]);
                color = carInfo[3];
            } else if (carInfo.length == 3) {
                if (Character.isDigit(carInfo[2].charAt(0))) {
                    weight = Integer.parseInt(carInfo[2]);
                } else {
                    color = carInfo[2];
                }
            }

            Engine carEngine = null;
            for (Engine engine : engines) {
                if (engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(carModel, carEngine, weight, color);
            System.out.print(car);
        }
    }
}
