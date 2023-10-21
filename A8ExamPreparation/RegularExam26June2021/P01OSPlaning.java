package A8ExamPreparation.RegularExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {
            int task = tasks.peek();
            int thread = threads.peek();

            if (task == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", thread, task);
                break;
            }

            if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else {
                threads.pop();
            }

        }

        System.out.println(threads.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
