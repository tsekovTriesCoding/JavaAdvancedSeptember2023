package A8ExamPreparation.RegularExam25June2022;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milk::offer);

        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoPowder::push);

        Map<String, Integer> chocolates = new TreeMap<>(Map.of
                ("Milk Chocolate", 0, "Dark Chocolate", 0, "Baking Chocolate", 0));

        while (!milk.isEmpty() && !cacaoPowder.isEmpty()) {
            double cacaoPercentage = cacaoPowder.peek() / (cacaoPowder.pop() + milk.peek()) * 100;

            if (cacaoPercentage == 30) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                milk.poll();
            } else if (cacaoPercentage == 50) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                milk.poll();
            } else if (cacaoPercentage == 100) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                milk.poll();
            } else {
                milk.addLast(milk.poll() + 10);
            }
        }

        boolean taskIsDone = true;

        for (Integer count : chocolates.values()) {
            if (count < 1) {
                taskIsDone = false;
                break;
            }
        }

        if (taskIsDone) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.forEach((k, v) -> {
            if (v > 0) {
                System.out.printf("# %s --> %d%n", k, v);
            }
        });

    }
}
