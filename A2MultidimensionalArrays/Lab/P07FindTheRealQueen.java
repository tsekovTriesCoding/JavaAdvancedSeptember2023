package A2MultidimentisionalArrays.Lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readCharMatrix(scanner);

        int rowQueen = 0;
        int colQueen = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentElement = matrix[row][col];

                boolean isAttacked = false;
                if (currentElement == 'q') {

                    isAttacked = checkNextVertical(col, isAttacked, matrix[row]);

                    isAttacked = checkPreviousVertical(matrix, row, col, isAttacked);

                    isAttacked = checkLowerHorizontal(matrix, row, col, isAttacked);

                    isAttacked = checkUpperHorizontal(matrix, row, col, isAttacked);

                    isAttacked = checkUpperLeftDiagonal(matrix, row, col, isAttacked);

                    isAttacked = checkUpperRightDiagonal(matrix, row, col, isAttacked);

                    isAttacked = checkLowerLeftDiagonal(matrix, row, col, isAttacked);

                    isAttacked = checkLowerRightDiagonal(matrix, row, col, isAttacked);

                    if (!isAttacked) {
                        rowQueen = row;
                        colQueen = col;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(rowQueen + " " + colQueen);

    }

    private static boolean checkLowerRightDiagonal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            int indexOfLowerRightDiagonal = col + 1;


            for (int i = row + 1; i < matrix.length; i++, indexOfLowerRightDiagonal++) {
                if (indexOfLowerRightDiagonal < matrix[row].length) {
                    char lowerRightDiagonalElement = matrix[i][indexOfLowerRightDiagonal];

                    if (lowerRightDiagonalElement == 'q') {
                        isAttacked = true;
                        break;
                    }
                }
            }
        }
        return isAttacked;
    }

    private static boolean checkLowerLeftDiagonal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            int indexOfLowerLeftDiagonal = col - 1;

            for (int i = row + 1; i < matrix.length; i++, indexOfLowerLeftDiagonal--) {
                if (indexOfLowerLeftDiagonal >= 0) {
                    char lowerLeftDiagonaElement = matrix[i][indexOfLowerLeftDiagonal];

                    if (lowerLeftDiagonaElement == 'q') {
                        isAttacked = true;
                        break;
                    }
                }
            }

        }
        return isAttacked;
    }

    private static boolean checkUpperRightDiagonal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            int indexOfUpperRightDiagonal = col + 1;


            for (int i = row - 1; i >= 0; i--, indexOfUpperRightDiagonal++) {
                if (indexOfUpperRightDiagonal < matrix.length) {
                    char upperRightDiagonalElement = matrix[i][indexOfUpperRightDiagonal];

                    if (upperRightDiagonalElement == 'q') {
                        isAttacked = true;
                        break;
                    }
                }
            }

        }
        return isAttacked;
    }

    private static boolean checkUpperLeftDiagonal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            int indexOfUpperLeftDiagonal = col - 1;


            for (int i = row - 1; i >= 0; i--, indexOfUpperLeftDiagonal--) {
                if (indexOfUpperLeftDiagonal >= 0) {
                    char upperLeftDiagonalElement = matrix[i][indexOfUpperLeftDiagonal];

                    if (upperLeftDiagonalElement == 'q') {
                        isAttacked = true;
                        break;
                    }
                }
            }

        }
        return isAttacked;
    }

    private static boolean checkUpperHorizontal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            for (int i = row - 1; i >= 0; i--) {
                char upperHorizontal = matrix[i][col];

                if (upperHorizontal == 'q') {
                    isAttacked = true;
                    break;
                }
            }
        }
        return isAttacked;
    }

    private static boolean checkLowerHorizontal(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            for (int i = row + 1; i < matrix.length; i++) {
                char lowerHorizontal = matrix[i][col];

                if (lowerHorizontal == 'q') {
                    isAttacked = true;
                    break;
                }
            }
        }
        return isAttacked;
    }

    private static boolean checkPreviousVertical(char[][] matrix, int row, int col, boolean isAttacked) {
        if (!isAttacked) {
            for (int i = col - 1; i >= 0; i--) {
                char previousVertical = matrix[row][i];

                if (previousVertical == 'q') {
                    isAttacked = true;
                    break;
                }
            }
        }
        return isAttacked;
    }

    private static boolean checkNextVertical(int col, boolean isAttacked, char[] matrix) {
        for (int i = col + 1; i < matrix.length; i++) {
            char nextVertical = matrix[i];

            if (nextVertical == 'q') {
                isAttacked = true;
                break;
            }
        }
        return isAttacked;
    }

    private static char[][] readCharMatrix(Scanner scanner) {

        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {
            char[] arr = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

            matrix[row] = arr;
        }

        return matrix;

    }
}
