package A8ExamPreparation.RetakeExam12April2023;

import java.util.*;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> time = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt)
                .forEach(time::offer);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        Map<String, Integer> ducksMap = new LinkedHashMap<>();
        ducksMap.put("Darth Vader Ducky", 0);
        ducksMap.put("Thor Ducky", 0);
        ducksMap.put("Big Blue Rubber Ducky", 0);
        ducksMap.put("Small Yellow Rubber Ducky", 0);

        while (!time.isEmpty() && !tasks.isEmpty()) {
            int timeNeeded = time.peek() * tasks.peek();

            if (timeNeeded >= 0 && timeNeeded <= 60) {
                ducksMap.put("Darth Vader Ducky", ducksMap.get("Darth Vader Ducky") + 1);
                time.poll();
                tasks.pop();
            } else if (timeNeeded >= 61 && timeNeeded <= 120) {
                ducksMap.put("Thor Ducky", ducksMap.get("Thor Ducky") + 1);
                time.poll();
                tasks.pop();
            } else if (timeNeeded >= 121 && timeNeeded <= 180) {
                ducksMap.put("Big Blue Rubber Ducky", ducksMap.get("Big Blue Rubber Ducky") + 1);
                time.poll();
                tasks.pop();
            } else if (timeNeeded >= 181 && timeNeeded <= 240) {
                ducksMap.put("Small Yellow Rubber Ducky", ducksMap.get("Small Yellow Rubber Ducky") + 1);
                time.poll();
                tasks.pop();
            } else if (timeNeeded > 240) {
                tasks.push(tasks.pop() - 2);
                time.addLast(time.pop());
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        ducksMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

}
