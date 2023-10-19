package A8ExamPreparation.RetakeExam16December2020;

import java.util.*;

public class P01Cooking {
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

        Map<String, Integer> food = new TreeMap<>();
        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Pastry", 0);
        food.put("Fruit Pie", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                food.put("Bread", food.get("Bread") + 1);
            } else if (sum == 50) {
                food.put("Cake", food.get("Cake") + 1);
            } else if (sum == 75) {
                food.put("Pastry", food.get("Pastry") + 1);
            } else if (sum == 100) {
                food.put("Fruit Pie", food.get("Fruit Pie") + 1);
            } else {
                ingredients.addFirst(ingredient + 3);
            }
        }

        boolean taskDone = true;

        for (Integer amount : food.values()) {
            if (amount == 0) {
                taskDone = false;
                break;
            }
        }

        if (taskDone) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        food.forEach((name, amount) -> {
            System.out.println(name + ": " + amount);
        });


    }
}
