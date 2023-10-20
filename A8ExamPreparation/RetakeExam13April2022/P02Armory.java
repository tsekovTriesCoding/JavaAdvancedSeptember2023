package A8ExamPreparation.RetakeExam13April2022;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        int officerRow = -1;
        int officerCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("A")) {
                    officerRow = row;
                    officerCol = col;
                }
            }
        }

        int goldPaid = 0;
        String move = scanner.nextLine();
        while (true) {
            matrix[officerRow][officerCol] = "-";

            switch (move) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            if (isOutOfTheArmory(size, officerRow, officerCol)) {
                System.out.println("I do not need more swords!");
                break;
            }

            if (Character.isDigit(matrix[officerRow][officerCol].charAt(0))) {
                goldPaid += Integer.parseInt(matrix[officerRow][officerCol]);
            } else if (matrix[officerRow][officerCol].equals("M")) {
                matrix[officerRow][officerCol] = "-";
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col].equals("M") && (officerRow != row && officerCol != col)) {
                            officerRow = row;
                            officerCol = col;
                            break;
                        }
                    }
                }
            }

            matrix[officerRow][officerCol] = "A";

            if (goldPaid >= 65) {
                System.out.println("Very nice swords, I will come back for more!");
                break;
            }
            move = scanner.nextLine();
        }

        System.out.printf("The king paid %d gold coins.%n", goldPaid);
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfTheArmory(int size, int officerRow, int officerCol) {
        return officerRow < 0 || officerRow >= size || officerCol < 0 || officerCol >= size;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
