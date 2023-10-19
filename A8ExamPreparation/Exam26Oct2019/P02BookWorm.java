package A8ExamPreparation.Exam26Oct2019;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String aString = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = fillMatrix(scanner, size);

        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (field[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();

        StringBuilder sb = new StringBuilder(aString);
        while (!command.equals("end")) {
            int startRow = playerRow;
            int startCol = playerCol;

            boolean isOutside = false;
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow++;
                        isOutside = true;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= size) {
                        playerRow--;
                        isOutside = true;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol++;
                        isOutside = true;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= size) {
                        playerCol--;
                        isOutside = true;
                    }
                    break;
            }

            if (!isOutside) {
                if (!field[playerRow][playerCol].equals("-")) {
                    sb.append(field[playerRow][playerCol]);
                }
                field[playerRow][playerCol] = "P";
                field[startRow][startCol] = "-";
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(sb);
        printMatrix(field);
    }

    private static String[][] fillMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] arr = scanner.nextLine().split("");
            matrix[row] = arr;
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
