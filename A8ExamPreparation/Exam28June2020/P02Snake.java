package A8ExamPreparation.Exam28June2020;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] territory = new String[size][size];
        fillMatrix(territory, scanner);

        int snakeRow = -1;
        int snakeCol = -1;
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                if (territory[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        boolean gameIsOver = false;
        int foodEaten = 0;
        while (!gameIsOver && foodEaten < 10) {
            territory[snakeRow][snakeCol] = ".";
            switch (command) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (snakeGoesOutside(snakeRow, snakeCol, size)) {
                gameIsOver = true;
                continue;
            }

            if (territory[snakeRow][snakeCol].equals("*")) {
                foodEaten++;
            } else if (territory[snakeRow][snakeCol].equals("B")) {
                territory[snakeRow][snakeCol] = ".";

                for (int row = 0; row < territory.length; row++) {
                    for (int col = 0; col < territory[row].length; col++) {
                        if (territory[row][col].equals("B")) {
                            snakeRow = row;
                            snakeCol = col;
                            break;
                        }
                    }
                }
            }

            territory[snakeRow][snakeCol] = "S";

            if (foodEaten < 10) {
                command = scanner.nextLine();
            }
        }

        if (gameIsOver) {
            System.out.println("Game over!");
        } else if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix(territory);


    }

    private static void printMatrix(String[][] territory) {
        for (String[] strings : territory) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean snakeGoesOutside(int snakeRow, int snakeCol, int size) {
        return snakeRow < 0 || snakeRow >= size || snakeCol < 0 || snakeCol >= size;
    }

    private static void fillMatrix(String[][] territory, Scanner scanner) {
        for (int row = 0; row < territory.length; row++) {
            territory[row] = scanner.nextLine().split("");
        }
    }
}
