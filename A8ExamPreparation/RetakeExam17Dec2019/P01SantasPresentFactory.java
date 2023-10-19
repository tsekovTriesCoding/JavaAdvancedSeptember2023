package A8ExamPreparation.RetakeExam17Dec2019;

import java.util.*;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(materialsStack::push);

        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(magicLevelQueue::offer);

        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int totalMagicLevel = materialsStack.peek() * magicLevelQueue.peek();

            if (totalMagicLevel == 150) {
                materialsStack.pop();
                magicLevelQueue.poll();
                presents.put("Doll", presents.get("Doll") + 1);
            } else if (totalMagicLevel == 250) {
                materialsStack.pop();
                magicLevelQueue.poll();
                presents.put("Wooden train", presents.get("Wooden train") + 1);
            } else if (totalMagicLevel == 300) {
                materialsStack.pop();
                magicLevelQueue.poll();
                presents.put("Teddy bear", presents.get("Teddy bear") + 1);
            } else if (totalMagicLevel == 400) {
                materialsStack.pop();
                magicLevelQueue.poll();
                presents.put("Bicycle", presents.get("Bicycle") + 1);
            } else if (totalMagicLevel < 0) {
                int sum = materialsStack.pop() + magicLevelQueue.poll();
                materialsStack.push(sum);
            } else if (totalMagicLevel > 0) {
                magicLevelQueue.poll();
                materialsStack.push(materialsStack.pop() + 15);
            } else {
                if (magicLevelQueue.peek() == 0) {
                    magicLevelQueue.poll();
                }
                if (materialsStack.peek() == 0) {
                    materialsStack.pop();
                }
            }

        }

        boolean taskDone = (presents.get("Doll") >= 1 && presents.get("Wooden train") >= 1) ||
                (presents.get("Teddy bear") >= 1 && presents.get("Bicycle") >= 1);

        if (taskDone) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.println("Materials left: " + materialsStack.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!magicLevelQueue.isEmpty()) {
            System.out.println("Magic left: " + magicLevelQueue.toString().replaceAll("[\\[\\]]", ""));
        }

        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }

    }
}
