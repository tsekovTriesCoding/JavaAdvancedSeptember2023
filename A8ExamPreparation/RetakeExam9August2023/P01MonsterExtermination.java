package A8ExamPreparation.RetakeExam9August2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> monstersArmor = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(monstersArmor::offer);

        ArrayDeque<Integer> soldiersImpact = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(soldiersImpact::push);

        int defeatedMonsters = 0;
        while (!monstersArmor.isEmpty() && !soldiersImpact.isEmpty()) {
            int monsterArmor = monstersArmor.peek();
            int soldierStrikeStrength = soldiersImpact.peek();

            if (soldierStrikeStrength >= monsterArmor) {
                defeatedMonsters++;
                monstersArmor.poll();
                int strengthLeft = soldiersImpact.pop() - monsterArmor;

                if (strengthLeft > 0) {
                    if (soldiersImpact.size() > 0) {
                        soldiersImpact.push(soldiersImpact.pop() + strengthLeft);
                    } else {
                        soldiersImpact.push(strengthLeft);
                    }
                }
            } else {
                monstersArmor.addLast(monstersArmor.poll() - soldierStrikeStrength);
                soldiersImpact.pop();
            }
        }

        if (monstersArmor.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldiersImpact.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", defeatedMonsters);

    }
}
