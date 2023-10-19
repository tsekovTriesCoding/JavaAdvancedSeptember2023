package A8ExamPreparation.RetakeExam19August2020;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] beeTerritory = new String[size][size];
        fillMatrix(beeTerritory, scanner);

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < beeTerritory.length; row++) {
            for (int col = 0; col < beeTerritory[row].length; col++) {
                if (beeTerritory[row][col].equals("B")) {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        String moveCommand = scanner.nextLine();
        int pollinatedFlowers = 0;
        boolean beeGotLost = false;
        while (!moveCommand.equals("End")) {
            beeTerritory[beeRow][beeCol] = ".";
            switch (moveCommand) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }

            if (beeGoesOut(beeRow, beeCol, size)) {
                beeGotLost = true;
                break;
            }
            if (beeTerritory[beeRow][beeCol].equals("O")) {
                beeTerritory[beeRow][beeCol] = ".";
                if (moveCommand.equals("up")) {
                    beeRow--;
                } else if (moveCommand.equals("down")) {
                    beeRow++;
                } else if (moveCommand.equals("left")) {
                    beeCol--;
                } else if (moveCommand.equals("right")) {
                    beeCol++;
                }
            }

            if (beeTerritory[beeRow][beeCol].equals("f")) {
                pollinatedFlowers++;
            }

            beeTerritory[beeRow][beeCol] = "B";

            moveCommand = scanner.nextLine();
        }

        if (beeGotLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        printMatrix(beeTerritory);
    }

    private static void printMatrix(String[][] beeTerritory) {
        for (String[] strings : beeTerritory) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean beeGoesOut(int beeRow, int beeCol, int size) {
        return beeRow < 0 || beeRow >= size || beeCol < 0 || beeCol >= size;
    }

    private static void fillMatrix(String[][] beeTerritory, Scanner scanner) {
        for (int row = 0; row < beeTerritory.length; row++) {
            beeTerritory[row] = scanner.nextLine().split("");
        }
    }
}
