package A2MultidimentisionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readCharMatrix(scanner, rows, cols);
        char[][] secondMatrix = readCharMatrix(scanner, rows, cols);

        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstMatrixElement = firstMatrix[row][col];
                char secondMatrixElement = secondMatrix[row][col];

                char resultChar = firstMatrixElement == secondMatrixElement ? firstMatrixElement : '*';
                outputMatrix[row][col] = resultChar;
            }
        }

        for (char[] chars : outputMatrix) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    private static char[][] readCharMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

            matrix[row] = arr;
        }

        return matrix;

    }
}
