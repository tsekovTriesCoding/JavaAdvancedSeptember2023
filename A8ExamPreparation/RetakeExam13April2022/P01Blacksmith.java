package A8ExamPreparation.RetakeExam13April2022;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(steel::offer);

        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(carbon::push);

        Map<String, Integer> swordCount = new TreeMap<>
                (Map.of("Gladius", 0, "Shamshir", 0, "Katana", 0, "Sabre", 0));
        int totalSwords = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int sum = steel.peek() + carbon.peek();

            if (sum == 70) {
                swordCount.put("Gladius", swordCount.get("Gladius") + 1);
                totalSwords = swordCreated(steel, carbon, totalSwords);
            } else if (sum == 80) {
                swordCount.put("Shamshir", swordCount.get("Shamshir") + 1);
                totalSwords = swordCreated(steel, carbon, totalSwords);
            } else if (sum == 90) {
                swordCount.put("Katana", swordCount.get("Katana") + 1);
                totalSwords = swordCreated(steel, carbon, totalSwords);
            } else if (sum == 110) {
                swordCount.put("Sabre", swordCount.get("Sabre") + 1);
                totalSwords = swordCreated(steel, carbon, totalSwords);
            } else {
                steel.poll();
                carbon.push(carbon.pop() + 5);
            }

        }

        if (totalSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + steel.toString().replaceAll("[\\[\\]]", ""));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.println("Carbon left: " + carbon.toString().replaceAll("[\\[\\]]", ""));
        }

        swordCount.entrySet().stream().filter(entry -> entry.getValue() > 0)
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

    }

    private static int swordCreated(ArrayDeque<Integer> steel, ArrayDeque<Integer> carbon, int totalSwords) {
        steel.poll();
        carbon.pop();
        totalSwords++;
        return totalSwords;
    }
}
