package A1StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsNamesAndTimes = scanner.nextLine().split(";");
        int[] startingTime = Arrays.stream(scanner.nextLine().split(":")).
                mapToInt(Integer::parseInt)
                .toArray();

        int hours = startingTime[0];
        int minutes = startingTime[1];
        int seconds = startingTime[2];
        int totalTimeInSeconds = seconds + minutes * 60 + hours * 3600;

        String[] robotsNames = new String[robotsNamesAndTimes.length];
        int[] processTime = new int[robotsNamesAndTimes.length];
        int[] workTime = new int[robotsNamesAndTimes.length];

        for (int i = 0; i < robotsNamesAndTimes.length; i++) {
            String[] currentRobot = robotsNamesAndTimes[i].split("-");
            String name = currentRobot[0];
            int time = Integer.parseInt(currentRobot[1]);
            robotsNames[i] = name;
            processTime[i] = time;
        }

        ArrayDeque<String> productQueue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String product = command;
            productQueue.offer(product);
            command = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {
            totalTimeInSeconds++;

            String product = productQueue.poll();

            boolean isFree = true;
            for (int i = 0; i < robotsNames.length; i++) {
                if (workTime[i] == 0 && isFree) {
                    workTime[i] = processTime[i];
                    isFree = false;
                    printOutput(totalTimeInSeconds, product, robotsNames[i]);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (isFree) {
                productQueue.offer(product);
            }
        }

    }

    private static void printOutput(int totalTimeInSeconds, String product, String robotName) {
        long seconds = totalTimeInSeconds % 60;
        long minutes = (totalTimeInSeconds / 60) % 60;
        long hours = (totalTimeInSeconds / (60 * 60)) % 24;
        String output = String.format("[%02d:%02d:%02d]", hours, minutes, seconds);

        System.out.printf("%s - %s %s%n", robotName, product, output);
    }
}
