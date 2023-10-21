package A8ExamPreparation.RetakeExam18August2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("Y")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        List<String> directionsToTreasure = new ArrayList<>();
        while (!command.equals("Finish")) {
            int prevRow = currentRow;
            int prevCol = currentCol;

            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (isOutOfTheField(currentRow, currentCol, rows, cols)) {
                currentRow = prevRow;
                currentCol = prevCol;
            } else {
                if (matrix[currentRow][currentCol].equals("T")) {
                    currentRow = prevRow;
                    currentCol = prevCol;
                } else if (matrix[currentRow][currentCol].equals("-")){
                    matrix[prevRow][prevCol] = "-";
                    matrix[currentRow][currentCol] = "Y";
                    directionsToTreasure.add(command);
                } else {
                    directionsToTreasure.add(command);
                    break;
                }
            }

            command = scanner.nextLine();
        }

        if (matrix[currentRow][currentCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", directionsToTreasure));
        } else {
            System.out.println("The map is fake!");
        }

    }

    private static boolean isOutOfTheField(int currentRow, int currentCol, int rows, int cols) {
        return currentRow < 0 || currentRow >= rows || currentCol < 0 || currentCol >= cols;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
