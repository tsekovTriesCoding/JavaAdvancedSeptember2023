package A8ExamPreparation.RetakeExam18August2021;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                food.put("Biscuit", food.get("Biscuit") + 1);
            } else if (sum == 50) {
                food.put("Cake", food.get("Cake") + 1);
            } else if (sum == 75) {
                food.put("Pastry", food.get("Pastry") + 1);
            } else if (sum == 100) {
                food.put("Pie", food.get("Pie") + 1);
            } else {
                ingredients.push(ingredient + 3);
            }

        }
        boolean taskIsDone = true;
        for (Integer count : food.values()) {
            if (count < 1) {
                taskIsDone = false;
                break;
            }
        }

        if (taskIsDone) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        food.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }
}
