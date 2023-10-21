package A8ExamPreparation.RetakeExam14December2022;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[size][size];
        fillMatrix(field, scanner);

        int submarineRow = -1;
        int submarineCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }

        int hitsTaken = 0;
        int cruisersCount = 3;
        String command = scanner.nextLine();
        while (true) {
            field[submarineRow][submarineCol] = "-";

            switch (command) {
                case "up":
                    submarineRow--;
                    break;
                case "down":
                    submarineRow++;
                    break;
                case "left":
                    submarineCol--;
                    break;
                case "right":
                    submarineCol++;
                    break;
            }

            if (field[submarineRow][submarineCol].equals("*")) {
                hitsTaken++;
            } else if (field[submarineRow][submarineCol].equals("C")) {
                cruisersCount--;
            }
            field[submarineRow][submarineCol] = "S";

            if (hitsTaken == 3) {
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                break;
            }
            if (cruisersCount == 0) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                break;
            }

            command = scanner.nextLine();
        }

        printMatrix(field);

    }

    private static void printMatrix(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] field, Scanner scanner) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
        }
    }
}
