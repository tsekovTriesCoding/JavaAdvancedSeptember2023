package A2MultidimentisionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int rowToBlast = tokens[0];
            int colToBlast = tokens[1];
            int radius = tokens[2];

            for (int row = rowToBlast - radius; row <= rowToBlast + radius; row++) {
                if (validCoordinates(matrix, row, colToBlast) && row != rowToBlast) {
                    matrix.get(row).remove(colToBlast);
                }
            }

            for (int col = colToBlast + radius; col >= colToBlast - radius; col--) {
                if (validCoordinates(matrix, rowToBlast, col)) {
                    matrix.get(rowToBlast).remove(col);
                }
            }

            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean validCoordinates(List<List<Integer>> matrix, int rowToBlast, int col) {
        return rowToBlast >= 0 && rowToBlast < matrix.size() && col >= 0 && col <= matrix.get(rowToBlast).size() - 1;
    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (List<Integer> currentRow : matrix) {
            for (Integer number : currentRow) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int count = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(count++);
            }
            matrix.add(currentRow);
        }
    }
}
