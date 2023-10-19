package A8ExamPreparation.Exam22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    private static int playerRow;
    private static int playerCol;
    private static boolean playerWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        getPlayerCoords(matrix);

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }

            if (playerWon) {
                break;
            }

        }

        System.out.println(playerWon ? "Player won!" : "Player lost!");

        printMatrix(matrix);
    }

    private static void getPlayerCoords(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }

    private static void movePlayer(String[][] matrix, int rowMutator, int colMutator) {
        matrix[playerRow][playerCol] = "-";
        playerRow += rowMutator;
        playerCol += colMutator;
        if (goesOutside(playerRow, playerCol, matrix.length)) {
            if (playerRow < 0 || playerRow >= matrix.length) {
                playerRow = playerRow < 0 ? matrix.length - 1 : 0;
            } else {
                playerCol = playerCol < 0 ? matrix.length -1 : 0;
            }
        } else if (matrix[playerRow][playerCol].equals("B")) {
            bonusMove(matrix, rowMutator, colMutator);
        } else if (matrix[playerRow][playerCol].equals("T")) {
            trapMove(matrix, rowMutator, colMutator);
        } else if (matrix[playerRow][playerCol].equals("F")) {
            playerWon = true;
        }

        if (matrix[playerRow][playerCol].equals("F")) {
            playerWon = true;
        }

        matrix[playerRow][playerCol] = "f";
    }

    private static void trapMove(String[][] matrix, int rowMutator, int colMutator) {
        playerRow -= rowMutator;
        playerCol -= colMutator;

        if (goesOutside(playerRow, playerCol, matrix.length)) {
            if (playerRow < 0 || playerRow >= matrix.length) {
                playerRow = playerRow < 0 ? matrix.length - 1 : 0;
            } else {
                playerCol = playerCol < 0 ? matrix.length - 1 : 0;
            }
        }

        if (matrix[playerRow][playerCol].equals("F")) {
            playerWon = true;
        }
    }

    private static void bonusMove(String[][] matrix, int rowMutator, int colMutator) {
        playerRow += rowMutator;
        playerCol += colMutator;

        if (goesOutside(playerRow, playerCol, matrix.length)) {
            if (playerRow < 0 || playerRow >= matrix.length) {
                playerRow = playerRow < 0 ? matrix.length - 1 : 0;
            } else {
                playerCol = playerCol < 0 ? matrix.length - 1 : 0;
            }
        }

        if (matrix[playerRow][playerCol].equals("F")) {
            playerWon = true;
        }
    }


    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean goesOutside(int playerRow, int playerCol, int size) {
        return playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
