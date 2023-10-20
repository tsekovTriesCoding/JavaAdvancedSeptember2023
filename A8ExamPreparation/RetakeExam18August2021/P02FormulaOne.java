package A8ExamPreparation.RetakeExam18August2021;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        String[] commands = new String[commandsCount];
        for (int i = 0; i < commandsCount; i++) {
            commands[i] = scanner.nextLine();
        }
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean wonTheRace = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (!matrix[playerRow][playerCol].equals("B")) {
                matrix[playerRow][playerCol] = ".";
            }
            int prevRow = playerRow;
            int prevCol = playerCol;

            switch (command) {
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

            if (goesOutside(size, playerRow, playerCol)) {
                if (playerRow < 0) {
                    playerRow = size - 1;
                } else if (playerRow >= size) {
                    playerRow = 0;
                } else if (playerCol < 0) {
                    playerCol = size - 1;
                } else if (playerCol >= size) {
                    playerCol = 0;
                }
            }

            if (matrix[playerRow][playerCol].equals("B")) {
                i--;
                continue;
            } else if (matrix[playerRow][playerCol].equals("F")) {
                wonTheRace = true;
                matrix[playerRow][playerCol] = "P";
                break;
            } else if (matrix[playerRow][playerCol].equals("T")) {
                playerRow = prevRow;
                playerCol = prevCol;
            }

            matrix[playerRow][playerCol] = "P";

        }

        if (wonTheRace) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);

    }

    private static boolean goesOutside(int size, int playerRow, int playerCol) {
        return playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
