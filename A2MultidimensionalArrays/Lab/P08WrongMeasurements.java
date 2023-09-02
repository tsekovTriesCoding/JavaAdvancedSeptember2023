package A2MultidimentisionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readIntMatrix(scanner, rows);

        int[] dimensionsOfWrongValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowOfWrongValue = dimensionsOfWrongValue[0];
        int colOfWrongValue = dimensionsOfWrongValue[1];

        int wrongValue = matrix[rowOfWrongValue][colOfWrongValue];

        int[][] resultMatrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            int[] currentArr = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                int newValue = 0;
                int currentValue = matrix[row][col];

                if (currentValue == wrongValue) {

                    newValue = getNewValue(matrix, wrongValue, row, col, newValue);

                    currentArr[col] = newValue;

                } else {
                    currentArr[col] = currentValue;
                }
            }

            resultMatrix[row] = currentArr;
        }

        printMatrix(resultMatrix);
    }

    private static int getNewValue(int[][] matrix, int wrongValue, int row, int col, int newValue) {
        int indexOfLeftElement = col - 1;

        if (indexOfLeftElement >= 0 && matrix[row][indexOfLeftElement] != wrongValue) {
            newValue += matrix[row][indexOfLeftElement];
        }

        int indexOfRightElement = col + 1;

        if (indexOfRightElement < matrix[row].length && matrix[row][indexOfRightElement] != wrongValue) {
            newValue += matrix[row][indexOfRightElement];
        }

        int indexOfUpperElement = row - 1;

        if (indexOfUpperElement >= 0 && matrix[indexOfUpperElement][col] != wrongValue) {
            newValue += matrix[indexOfUpperElement][col];
        }

        int indexOfLowerElement = row + 1;

        if (indexOfLowerElement < matrix.length && matrix[indexOfLowerElement][col] != wrongValue) {
            newValue += matrix[indexOfLowerElement][col];
        }
        return newValue;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readIntMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
