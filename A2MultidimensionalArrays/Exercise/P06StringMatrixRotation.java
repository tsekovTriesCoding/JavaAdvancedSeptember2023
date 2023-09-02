package A2MultidimentisionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotationDegrees = Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        int rotations = rotationDegrees % 360;
        String command = scanner.nextLine();
        List<String> wordsList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while (!command.equals("END")) {
            wordsList.add(command);
            if (command.length() > maxLength) {
                maxLength = command.length();
            }
            command = scanner.nextLine();
        }

        int rows = wordsList.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, wordsList);

        switch (rotations) {
            case 90:
                matrix = rotate90(matrix, rows, cols);
                break;
            case 180:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                break;
            case 270:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                matrix = rotate90(matrix, rows, cols);
                break;
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        char[][] rotatedMatrix = new char[cols][rows];

        for (int col = 0; col < cols; col++) {
            int newCol = 0;
            for (int row = rows - 1; row >= 0; row--) {
                rotatedMatrix[col][newCol++] = matrix[row][col];
            }
        }

        return rotatedMatrix;

    }

    private static void fillMatrix(char[][] matrix, List<String> wordsList) {
        for (int row = 0; row < matrix.length; row++) {
            String word = wordsList.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < word.length()) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

}
