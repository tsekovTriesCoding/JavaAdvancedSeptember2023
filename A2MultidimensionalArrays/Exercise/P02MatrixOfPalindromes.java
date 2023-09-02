package A2MultidimentisionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] palindromeMatrix = new String[rows][cols];

        fillPalindromeMatrix(palindromeMatrix);

        printMatrix(palindromeMatrix);
    }

    private static void printMatrix(String[][] palindromeMatrix) {

        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                System.out.print(palindromeMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillPalindromeMatrix(String[][] palindromeMatrix) {

        for (int row = 0; row < palindromeMatrix.length; row++) {
            char firstAndLast = (char) ('a' + row);
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                char midLetter = (char) ('a' + row + col);

                palindromeMatrix[row][col] = "" + firstAndLast + midLetter + firstAndLast;
            }
        }
    }
}
