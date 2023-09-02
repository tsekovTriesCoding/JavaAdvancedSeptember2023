package A2MultidimentisionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillMatrix(matrix, scanner);

        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);

        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

    }
}
