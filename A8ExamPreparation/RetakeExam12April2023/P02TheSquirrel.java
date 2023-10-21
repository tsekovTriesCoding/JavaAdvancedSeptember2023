package A8ExamPreparation.RetakeExam12April2023;

import java.util.Scanner;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int collectedHazelnuts = 0;
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        String[][] field = createMatrix(size, scanner);

        int squirrelRow = -1;
        int squirrelCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("s")) {
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
        }

        boolean isOutOfTheField = false;
        boolean steppedOnATrap = false;
        for (String command : commands) {
            switch (command) {
                case "up":
                    squirrelRow--;
                    break;
                case "down":
                    squirrelRow++;
                    break;
                case "left":
                    squirrelCol--;
                    break;
                case "right":
                    squirrelCol++;
                    break;
            }

            if (isOutOfTheField(squirrelRow, squirrelCol, size)) {
                isOutOfTheField = true;
                break;
            }

            if (field[squirrelRow][squirrelCol].equals("h")) {
                field[squirrelRow][squirrelCol] = "*";
                collectedHazelnuts++;

                if (collectedHazelnuts == 3) {
                    break;
                }
            } else if (field[squirrelRow][squirrelCol].equals("t")) {
                steppedOnATrap = true;
                break;
            }
        }

        if (isOutOfTheField) {
            System.out.println("The squirrel is out of the field.");
        } else if (steppedOnATrap) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (collectedHazelnuts < 3) {
            System.out.println("There are more hazelnuts to collect.");
        } else {
            System.out.println("Good job! You have collected all hazelnuts!");
        }

        System.out.println("Hazelnuts collected: " + collectedHazelnuts);

    }

    private static boolean isOutOfTheField(int squirrelRow, int squirrelCol, int size) {
        return squirrelRow < 0 || squirrelRow >= size || squirrelCol < 0 || squirrelCol >= size;
    }


    private static String[][] createMatrix(int size, Scanner scanner) {
        String[][] matrix = new String[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

        return matrix;
    }
}
