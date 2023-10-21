package A8ExamPreparation.RegularExam26June2021;

import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] screen = new String[size][size];
        fillMatrix(screen, scanner);

        int pythonRow = -1;
        int pythonCol = -1;

        int foodCount = 0;
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                if (screen[row][col].equals("s")) {
                    pythonRow = row;
                    pythonCol = col;
                } else if (screen[row][col].equals("f")) {
                    foodCount++;
                }
            }
        }

        int pythonLength = 1;
        for (String command : commands) {
            screen[pythonRow][pythonCol] = "*";
            switch (command) {
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
            }

            if (goesOutside(pythonRow, pythonCol, size)) {
                if (pythonRow < 0) {
                    pythonRow = size - 1;
                } else if (pythonRow >= size) {
                    pythonRow = 0;
                } else if (pythonCol < 0) {
                    pythonCol = size - 1;
                } else if (pythonCol >= size) {
                    pythonCol = 0;
                }
            }

            if (screen[pythonRow][pythonCol].equals("f")) {
                foodCount--;
                pythonLength++;
            } else if (screen[pythonRow][pythonCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            screen[pythonRow][pythonCol] = "s";

            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %d", pythonLength);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodCount);


    }

    private static boolean goesOutside(int pythonRow, int pythonCol, int size) {
        return pythonRow < 0 || pythonRow >= size || pythonCol < 0 || pythonCol >= size;
    }

    private static void fillMatrix(String[][] screen, Scanner scanner) {
        for (int row = 0; row < screen.length; row++) {
            screen[row] = scanner.nextLine().split("\\s+");
        }
    }
}
