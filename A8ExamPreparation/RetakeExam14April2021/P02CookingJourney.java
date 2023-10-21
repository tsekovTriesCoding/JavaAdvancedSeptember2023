package A8ExamPreparation.RetakeExam14April2021;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] pastryShopMatrix = new String[size][size];
        fillMatrix(pastryShopMatrix, scanner);

        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < pastryShopMatrix.length; row++) {
            for (int col = 0; col < pastryShopMatrix[row].length; col++) {
                if (pastryShopMatrix[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int collectedMoney = 0;
        boolean goesOutside = false;
        while (collectedMoney < 50) {
            String command = scanner.nextLine();

            pastryShopMatrix[currentRow][currentCol] = "-";
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

            if (goesOutside(currentRow, currentCol, size)) {
                goesOutside = true;
                break;
            }

            if (Character.isDigit(pastryShopMatrix[currentRow][currentCol].charAt(0))) {
                collectedMoney += Integer.parseInt(pastryShopMatrix[currentRow][currentCol]);
            } else if (pastryShopMatrix[currentRow][currentCol].equals("P")) {
                pastryShopMatrix[currentRow][currentCol] = "-";
                for (int row = 0; row < pastryShopMatrix.length; row++) {
                    for (int col = 0; col < pastryShopMatrix[currentRow].length; col++) {
                        if (pastryShopMatrix[row][col].equals("P")) {
                            currentRow = row;
                            currentCol = col;
                            break;
                        }
                    }
                }
            }

            pastryShopMatrix[currentRow][currentCol] = "S";
        }

        if (goesOutside) {
            System.out.println("Bad news! You are out of the pastry shop.");

        }

        if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + collectedMoney);
        printMatrix(pastryShopMatrix);


    }

    private static void printMatrix(String[][] pastryShopMatrix) {
        for (String[] shopMatrix : pastryShopMatrix) {
            for (String matrix : shopMatrix) {
                System.out.print(matrix);
            }
            System.out.println();
        }
    }

    private static boolean goesOutside(int currentRow, int currentCol, int size) {
        return currentRow < 0 || currentRow >= size || currentCol < 0 || currentCol >= size;
    }


    private static void fillMatrix(String[][] pastryShopMatrix, Scanner scanner) {
        for (int row = 0; row < pastryShopMatrix.length; row++) {
            pastryShopMatrix[row] = scanner.nextLine().split("");
        }
    }
}
