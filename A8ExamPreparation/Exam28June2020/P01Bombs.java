package A8ExamPreparation.Exam28June2020;

import java.util.*;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombEffects::offer);

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasings::push);

        Map<String, Integer> bombPouch = new TreeMap<>();
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);
        boolean bombPouchFull = false;
        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            bombPouchFull = getPouchState(bombPouch, bombPouchFull);

            if (bombPouchFull) {
                break;
            }
            int bombEffect = bombEffects.poll();
            int bombCasing = bombCasings.pop();

            int sum = bombEffect + bombCasing;
            if (sum == 40) {
                bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
            } else if (sum == 120) {
                bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
            } else {
                bombEffects.addFirst(bombEffect);
                bombCasings.push(bombCasing - 5);
            }


        }

        printBombPouchState(bombPouchFull);
        printBombEffectsState(bombEffects);
        printBombCasingsState(bombCasings);

        bombPouch.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private static void printBombCasingsState(ArrayDeque<Integer> bombCasings) {
        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombCasings.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    private static void printBombEffectsState(ArrayDeque<Integer> bombEffects) {
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffects.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    private static void printBombPouchState(boolean bombPouchFull) {
        if (!bombPouchFull) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
    }

    private static boolean getPouchState(Map<String, Integer> bombPouch, boolean bombPouchFull) {
        for (Integer value : bombPouch.values()) {
            bombPouchFull = value >= 3;
            if (!bombPouchFull) {
                break;
            }
        }
        return bombPouchFull;
    }
}
