package A8ExamPreparation.RegularExam18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        String[][] playground = new String[rows][cols];
        fillMatrix(playground, scanner);

        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < playground.length; row++) {
            for (int col = 0; col < playground[row].length; col++) {
                if (playground[row][col].equals("B")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String direction = scanner.nextLine();

        int opponentsTouched = 0;
        int movesMade = 0;
        while (!direction.equals("Finish")) {
            int prevRow = playerRow;
            int prevCol = playerCol;
            switch (direction) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if (isOutOfTheField(playerRow, playerCol, rows, cols)) {
                playerRow = prevRow;
                playerCol = prevCol;
            } else {
                if (playground[playerRow][playerCol].equals("-")) {
                    playground[prevRow][prevCol] = "-";
                    playground[playerRow][playerCol] = "B";
                    movesMade++;
                } else if (playground[playerRow][playerCol].equals("P")) {
                    playground[prevRow][prevCol] = "-";
                    playground[playerRow][playerCol] = "B";
                    movesMade++;
                    opponentsTouched++;
                    playground[playerRow][playerCol] = "-";
                } else if (playground[playerRow][playerCol].equals("O")) {
                    playerRow = prevRow;
                    playerCol = prevCol;
                }
            }

            if (opponentsTouched == 3) {
                break;
            }

            direction = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponentsTouched, movesMade);

    }

    private static boolean isOutOfTheField(int playerRow, int playerCol, int rows, int cols) {
        return playerRow < 0 || playerRow >= rows || playerCol < 0 || playerCol >= cols;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

    }
}
