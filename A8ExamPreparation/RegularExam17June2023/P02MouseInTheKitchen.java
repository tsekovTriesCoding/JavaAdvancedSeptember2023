package A8ExamPreparation.RegularExam17June2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] cupboardArea = createMatrix(scanner, rows, cols);
        int mouseRow = -1;
        int mouseCol = -1;
        int cheeseCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (cupboardArea[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                    break;
                } else if (cupboardArea[row][col].equals("C")) {
                    cheeseCount++;
                }
            }

        }

        String command = scanner.nextLine();

        boolean isOutside = false;
        boolean cheeseIsEaten = false;
        boolean mouseIsTrapped = false;
        while (!command.equals("danger")) {
            int lastRow = mouseRow;
            int lastCol = mouseCol;

            cupboardArea[mouseRow][mouseCol] = "*";
            if (command.equals("up")) {
                mouseRow--;
                if (mouseRow < 0) {
                    isOutside = true;
                }
            } else if (command.equals("down")) {
                mouseRow++;
                if (mouseRow >= rows) {
                    isOutside = true;
                }
            } else if (command.equals("right")) {
                mouseCol++;
                if (mouseCol >= cols) {
                    isOutside = true;
                }
            } else if (command.equals("left")) {
                mouseCol--;
                if (mouseCol < 0) {
                    isOutside = true;
                }
            }

            if (isOutside) {
                cupboardArea[lastRow][lastCol] = "M";
                break;
            }

            String currentText = cupboardArea[mouseRow][mouseCol];

            if (currentText.equals("C")) {
                cheeseCount--;
            } else if (currentText.equals("T")) {
                mouseIsTrapped = true;
            } else if (currentText.equals("@")) {
                mouseRow = lastRow;
                mouseCol = lastCol;
            }

            cupboardArea[mouseRow][mouseCol] = "M";
            if (mouseIsTrapped) {
                break;
            }
            if (cheeseCount == 0) {
                cheeseIsEaten = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (isOutside) {
            System.out.println("No more cheese for tonight!");
        } else if (cheeseIsEaten) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        } else if (mouseIsTrapped) {
            System.out.println("Mouse is trapped!");
        } else {
            System.out.println("Mouse will come back later!");
        }

        printMatrix(cupboardArea);

    }

    private static void printMatrix(String[][] cupboardArea) {
        for (String[] strings : cupboardArea) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }


    private static String[][] createMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("");
            matrix[row] = arr;
        }

        return matrix;

    }
}
