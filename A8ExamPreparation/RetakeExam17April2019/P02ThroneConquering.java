package A8ExamPreparation.RetakeExam17April2019;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyOfParis = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[size][size];
        fillMatrix(field, scanner);

        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("P")) {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        String[] input = scanner.nextLine().split("\\s+");

        while (true) {
            String command = input[0];
            int spawnRow = Integer.parseInt(input[1]);
            int spawnCol = Integer.parseInt(input[2]);
            field[spawnRow][spawnCol] = "S";

            int parisPrevRow = parisRow;
            int parisPrevCol = parisCol;
            switch (command) {
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "right":
                    parisCol++;
                    break;
            }

            energyOfParis -= 1;
            if (goesOutOfTheField(parisRow, parisCol, size)) {
                parisRow = parisPrevRow;
                parisCol = parisPrevCol;
            } else {
                field[parisPrevRow][parisPrevCol] = "-";
                if (field[parisRow][parisCol].equals("S")) {
                    energyOfParis -= 2;
                    field[parisRow][parisCol] = "P";
                } else if (field[parisRow][parisCol].equals("H")) {
                    field[parisRow][parisCol] = "-";
                    System.out.printf("Paris has successfully sat on the throne! Energy left: %d%n", energyOfParis);
                    break;
                } else {
                    field[parisRow][parisCol] = "P";
                }
                if (energyOfParis <= 0) {
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    field[parisRow][parisCol] = "X";
                    break;
                }
            }

            input = scanner.nextLine().split("\\s+");
        }

        printMatrix(field);
    }

    private static void printMatrix(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean goesOutOfTheField(int parisRow, int parisCol, int size) {
        return parisRow < 0 || parisRow >= size || parisCol < 0 || parisCol >= size;
    }

    private static void fillMatrix(String[][] field, Scanner scanner) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
        }
    }
}
