package A8ExamPreparation.RegularExam17June2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(toolsQueue::offer);

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(substancesStack::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean passedAllChallenges = false;
        while (!substancesStack.isEmpty() && !toolsQueue.isEmpty()) {
            int result = toolsQueue.peek() * substancesStack.peek();

            if (challenges.contains(result)) {
                toolsQueue.poll();
                substancesStack.pop();
                challenges.remove(Integer.valueOf(result));
            } else {
                toolsQueue.addLast(toolsQueue.poll() + 1);
                int substanceValue = substancesStack.pop();

                if (substanceValue - 1 > 0) {
                    substancesStack.push(substanceValue - 1);
                }
            }

            if (challenges.isEmpty()) {
                passedAllChallenges = true;
                break;
            }
        }

        if (passedAllChallenges) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.println("Tools: " + toolsQueue.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!substancesStack.isEmpty()) {
            System.out.println("Substances: " + substancesStack.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
