package A8ExamPreparation.RetakeExam17April2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01CatapultAttack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilesCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> walls = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(walls::offer);
        ArrayDeque<Integer> rocks = new ArrayDeque<>();


        for (int i = 1; i <= pilesCount; i++) {
            if (walls.isEmpty()) {
                break;
            }
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .forEach(rocks::push);

            if (i % 3 == 0) {
                walls.offer(Integer.valueOf(scanner.nextLine()));
            }

            while (!rocks.isEmpty() && !walls.isEmpty()) {
                int wall = walls.poll();
                int rock = rocks.pop();

                if (rock > wall) {
                    rock -= wall;
                    rocks.push(rock);
                } else if (wall > rock) {
                    wall -= rock;
                    walls.addFirst(wall);
                }
            }
        }

        if (!rocks.isEmpty()) {
            System.out.println("Rocks left: " + rocks.toString().replaceAll("[\\[\\]]", ""));
        } else if (!walls.isEmpty()) {
            System.out.println("Walls left: " + walls.toString().replaceAll("[\\[\\]]", ""));
        }


    }
}
