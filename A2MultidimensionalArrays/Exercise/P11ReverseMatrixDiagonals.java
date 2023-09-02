package A2MultidimentisionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix,scanner);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){
            int r = row;
            int c = col;
            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if(col == -1){
                col = 0;
                row--;
            }
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = (Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt))
                    .toArray();
        }

    }
}
