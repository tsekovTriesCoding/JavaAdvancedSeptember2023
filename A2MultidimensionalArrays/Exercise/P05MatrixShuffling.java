package A2MultidimentisionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("swap") && tokens.length == 5) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                boolean validCoordinates = validCoordinates(matrix, row1, col1, row2, col2);

                if (validCoordinates) {
                    String value1 = matrix[row1][col1];
                    String value2 = matrix[row2][col2];
                    matrix[row1][col1] = value2;
                    matrix[row2][col2] = value1;

                    printMatrix(matrix, rows, cols);
                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validCoordinates(String[][] matrix, int row1, int col1, int row2, int col2) {
        return (row1 >= 0 && row1 < matrix.length) && (col1 >= 0 && col1 < matrix[row1].length)
                && (row2 >= 0 && row2 < matrix.length) && (col2 >= 0 && col2 < matrix[row2].length);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = (scanner.nextLine().split("\\s+"));
        }

    }
}
