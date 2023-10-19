package A8ExamPreparation.Exam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstLootBox::offer);

        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBox::push);

        int claimedItems = 0;
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int firstBoxItem = firstLootBox.poll();
            int secondBoxItem = secondLootBox.pop();

            int sum = firstBoxItem + secondBoxItem;
            if (sum % 2 == 0) {
                claimedItems += sum;
            } else {
                firstLootBox.addFirst(firstBoxItem);
                firstLootBox.offer(secondBoxItem);
            }
        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondLootBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }


    }
}
