package A8ExamPreparation.RegularExam22October2022;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        int totalDistance = 0;
        int carRow = 0;
        int carCol = 0;
        boolean finished = false;
        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    carRow--;
                    break;
                case "down":
                    carRow++;
                    break;
                case "left":
                    carCol--;
                    break;
                case "right":
                    carCol++;
                    break;
            }

            if (matrix[carRow][carCol].equals("T")) {
                matrix[carRow][carCol] = ".";
                for (int row = 0; row < matrix[carRow].length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col].equals("T")) {
                            carRow = row;
                            carCol = col;
                        }
                    }
                }
                totalDistance += 30;
                matrix[carRow][carCol] = ".";
            } else if (matrix[carRow][carCol].equals("F")) {
                totalDistance += 10;
                finished = true;
                break;
            } else {
                totalDistance += 10;
            }

            command = scanner.nextLine();
        }

        matrix[carRow][carCol] = "C";
        if (finished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", totalDistance);
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
