package Exam;

import java.util.Collections;
import java.util.Scanner;

public class P02FishingCompetition {
    private static int currentRow;
    private static int currentCol;
    private static int fishCaught;
    private static boolean fellInAWhirlpool;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] fishingArea = new String[size][size];
        fillMatrix(fishingArea, scanner);

        getCoordinates(fishingArea);

        String command = scanner.nextLine();

        while (!command.equals("collect the nets")) {
            move(command, fishingArea);

            if (fellInAWhirlpool) {
                break;
            }

            command = scanner.nextLine();
        }

        if (fellInAWhirlpool) {
            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n",
                    currentRow, currentCol);
        } else {
            if (fishCaught >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.print("You didn't catch enough fish and didn't reach the quota! ");
                System.out.printf("You need %d tons of fish more.%n", 20 - fishCaught);
            }

            if (fishCaught > 0) {
                System.out.printf("Amount of fish caught: %d tons.%n", fishCaught);
            }

            printMatrix(fishingArea);
        }

    }

    private static void move(String command, String[][] fishingArea) {
        fishingArea[currentRow][currentCol] = "-";
        switch (command) {
            case "up":
                currentRow--;
                break;
            case "down":
                currentRow++;
                break;
            case "left":
                currentCol--;
                break;
            case "right":
                currentCol++;
                break;
        }

        if (goesOutside(currentRow, currentCol, fishingArea.length)) {
            if (currentRow < 0) {
                currentRow = fishingArea.length - 1;
            } else if (currentRow >= fishingArea.length) {
                currentRow = 0;
            } else if (currentCol < 0) {
                currentCol = fishingArea.length - 1;
            } else if (currentCol >= fishingArea.length) {
                currentCol = 0;
            }
        }

        if (Character.isDigit(fishingArea[currentRow][currentCol].charAt(0))) {
            fishCaught += Integer.parseInt(fishingArea[currentRow][currentCol]);
        } else if (fishingArea[currentRow][currentCol].equals("W")) {
            fishCaught = 0;
            fellInAWhirlpool = true;
        }

        fishingArea[currentRow][currentCol] = "S";
    }

    private static void getCoordinates(String[][] fishingArea) {
        for (int row = 0; row < fishingArea.length; row++) {
            for (int col = 0; col < fishingArea[row].length; col++) {
                if (fishingArea[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                    return;
                }
            }
        }
    }

    private static void printMatrix(String[][] fishingArea) {
        for (String[] strings : fishingArea) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean goesOutside(int currentRow, int currentCol, int size) {
        return currentRow < 0 || currentRow >= size || currentCol < 0 || currentCol >= size;
    }

    private static void fillMatrix(String[][] fishingArea, Scanner scanner) {
        for (int row = 0; row < fishingArea.length; row++) {
            fishingArea[row] = scanner.nextLine().split("");
        }
    }
}
