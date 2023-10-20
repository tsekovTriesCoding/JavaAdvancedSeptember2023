package A8ExamPreparation.RegularExam23October2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] mouseTerritory = new String[size][size];
        fillMatrix(mouseTerritory, scanner);

        int mouseRow = -1;
        int mouseCol = -1;
        for (int row = 0; row < mouseTerritory.length; row++) {
            for (int col = 0; col < mouseTerritory[row].length; col++) {
                if (mouseTerritory[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        int cheeseEaten = 0;
        while (!command.equals("end")) {
            mouseTerritory[mouseRow][mouseCol] = "-";
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            if (isOutOfTheField(size, mouseRow, mouseCol)) {
                System.out.println("Where is the mouse?");
                break;
            } else {
                if (mouseTerritory[mouseRow][mouseCol].equals("c")) {
                    cheeseEaten++;
                } else if (mouseTerritory[mouseRow][mouseCol].equals("B")) {
                    continue;
                }

                mouseTerritory[mouseRow][mouseCol] = "M";

            }

            command = scanner.nextLine();
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printMatrix(mouseTerritory);

    }

    private static void printMatrix(String[][] mouseTerritory) {
        for (String[] strings : mouseTerritory) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfTheField(int size, int mouseRow, int mouseCol) {
        return mouseRow < 0 || mouseRow >= size || mouseCol < 0 || mouseCol >= size;
    }

    private static void fillMatrix(String[][] mouseTerritory, Scanner scanner) {
        for (int row = 0; row < mouseTerritory.length; row++) {
            mouseTerritory[row] = scanner.nextLine().split("");
        }
    }
}
