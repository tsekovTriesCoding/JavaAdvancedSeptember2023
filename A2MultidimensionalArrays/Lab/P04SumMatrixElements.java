package A2MultidimentisionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(scanner, rows, cols);

        System.out.println(rows);
        System.out.println(cols);
        printSumOfMatrixElements(matrix);
    }

    private static void printSumOfMatrixElements(int[][] matrix) {
        int sum = 0;

        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }

        return matrix;

    }
}
