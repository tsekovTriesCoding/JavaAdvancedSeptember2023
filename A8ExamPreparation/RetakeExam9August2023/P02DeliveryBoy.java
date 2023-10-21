package A8ExamPreparation.RetakeExam9August2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int boyRow = -1;
        int boyCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    boyRow = row;
                    boyCol = col;
                }
            }
        }

        int boyInitialRow = boyRow;
        int boyInitialCol = boyCol;
        boolean outOfMatrix = false;
        String command = scanner.nextLine();
        while (true) {
            int prevRow = boyRow;
            int prevCol = boyCol;
            switch (command) {
                case "up":
                    boyRow--;
                    break;
                case "down":
                    boyRow++;
                    break;
                case "left":
                    boyCol--;
                    break;
                case "right":
                    boyCol++;
                    break;
            }

            if (boyRow < 0 || boyRow >= rows || boyCol < 0 || boyCol >= cols) {
                outOfMatrix = true;
                break;
            }

            if (matrix[boyRow][boyCol].equals("P")) {
                matrix[boyRow][boyCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[boyRow][boyCol].equals("*")) {
                boyRow = prevRow;
                boyCol = prevCol;
            } else if (matrix[boyRow][boyCol].equals("A")) {
                matrix[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            } else if (matrix[boyRow][boyCol].equals("-")) {
                matrix[boyRow][boyCol] = ".";
            }


            command = scanner.nextLine();
        }

        if (outOfMatrix) {
            matrix[boyInitialRow][boyInitialCol] = " ";
            System.out.println("The delivery is late. Order is canceled.");
        } else {
            matrix[boyInitialRow][boyInitialCol] = "B";
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
