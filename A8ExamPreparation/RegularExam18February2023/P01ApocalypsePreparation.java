package A8ExamPreparation.RegularExam18February2023;

import java.util.*;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(textiles::offer);

        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(medicaments::push);

        Map<String, Integer> itemsMap = new TreeMap<>();
        itemsMap.put("Patch", 0);
        itemsMap.put("Bandage", 0);
        itemsMap.put("MedKit", 0);
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int sum = textiles.peek() + medicaments.peek();

            if (sum == 30) {
                textiles.poll();
                medicaments.pop();
                itemsMap.put("Patch", itemsMap.get("Patch") + 1);
            } else if (sum == 40) {
                textiles.poll();
                medicaments.pop();
                itemsMap.put("Bandage", itemsMap.get("Bandage") + 1);
            } else if (sum == 100) {
                textiles.poll();
                medicaments.pop();
                itemsMap.put("MedKit", itemsMap.get("MedKit") + 1);
            } else if (sum > 100) {
                itemsMap.put("MedKit", itemsMap.get("MedKit") + 1);
                textiles.poll();
                medicaments.pop();
                medicaments.push(medicaments.pop() + sum - 100);
            } else {
                textiles.poll();
                medicaments.push(medicaments.pop() + 10);
            }

        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }

        itemsMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        if (!medicaments.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medicaments.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!textiles.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textiles.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
