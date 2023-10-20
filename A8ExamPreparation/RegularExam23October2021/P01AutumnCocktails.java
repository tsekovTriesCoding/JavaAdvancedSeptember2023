package A8ExamPreparation.RegularExam23October2021;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::offer);

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktails = new TreeMap<>(Map.of(
                "Pear Sour", 0,
                "The Harvest", 0,
                "Apple Hinny", 0,
                "High Fashion", 0));
        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            if (ingredients.peek() ==0) {
                ingredients.poll();
                continue;
            }
            int totalFreshness = ingredients.peek() * freshness.peek();

            if (totalFreshness == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (totalFreshness == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (totalFreshness == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                ingredients.poll();
                freshness.pop();
            } else if (totalFreshness == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.pop();
                ingredients.addLast(ingredients.poll() + 5);

            }

        }

        boolean taskFailed = false;
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() < 1) {
                taskFailed = true;
                break;
            }
        }

        if (!taskFailed) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            System.out.print("Ingredients left: ");
            System.out.println(ingredients.stream().mapToInt(Integer::intValue).sum());
        }

        cocktails.forEach((name, amount) -> {
            if (amount > 0) {
                System.out.printf(" # %s --> %d%n", name, amount);
            }
        });
    }
}
