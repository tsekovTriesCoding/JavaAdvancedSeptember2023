package A3SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> foodShopsMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            foodShopsMap.putIfAbsent(shop, new LinkedHashMap<>());
            foodShopsMap.get(shop).putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : foodShopsMap.entrySet()) {
            System.out.println(entry.getKey() + "->");
            entry.getValue().forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
        }
    }
}
