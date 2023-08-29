package A1StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        int counter = 1;
        for (String name : names) {
            queue.offer(name);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(counter)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            counter++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if ((number % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
