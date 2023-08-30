package A1StacksAndQueues.Exercise;

import java.util.*;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] pesticidesAmount = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt)
                .toArray();

        int[] deathDay = new int[n];
        ArrayDeque<Integer> plantStack = new ArrayDeque<>();

        plantStack.push(0);

        for (int i = 1; i < n; i++) {
            int lastDayOfPlant = 0;
            while (!plantStack.isEmpty() && pesticidesAmount[plantStack.peek()] >= pesticidesAmount[i]) {
                lastDayOfPlant = Math.max(lastDayOfPlant, deathDay[plantStack.pop()]);
            }
            if (!plantStack.isEmpty()) {
                deathDay[i] = lastDayOfPlant + 1;
            }

            plantStack.push(i);
        }

        System.out.println(Arrays.stream(deathDay).boxed().max(Integer::compare).get());
    }
}
