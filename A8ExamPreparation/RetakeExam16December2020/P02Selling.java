package A8ExamPreparation.RetakeExam16December2020;

import java.util.Scanner;

public class P02Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] bakery = new String[size][size];
        fillMatrix(bakery, scanner);

        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int collectedMoney = 0;
        boolean goesOutside = false;
        while (collectedMoney < 50) {
            String direction = scanner.nextLine();

            bakery[currentRow][currentCol] = "-";
            switch (direction) {
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

            if (Character.isDigit(bakery[currentRow][currentCol].charAt(0))) {
                collectedMoney += Integer.parseInt(bakery[currentRow][currentCol]);
            } else if (bakery[currentRow][currentCol].equals("O")) {
                bakery[currentRow][currentCol] = "-";
                for (int row = 0; row < bakery.length; row++) {
                    for (int col = 0; col < bakery[row].length; col++) {
                        if (bakery[row][col].equals("O")) {
                            currentRow = row;
                            currentCol = col;
                            break;
                        }
                    }
                }
            }

            bakery[currentRow][currentCol] = "S";
        }

        if (goesOutside) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + collectedMoney);
        printMatrix(bakery);
    }

    private static void printMatrix(String[][] bakery) {
        for (String[] strings : bakery) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean goesOutside(int currentRow, int currentCol, int size) {
        return currentRow < 0 || currentRow >= size || currentCol < 0 || currentCol >= size;
    }

    private static void fillMatrix(String[][] bakery, Scanner scanner) {
        for (int row = 0; row < bakery.length; row++) {
            bakery[row] = scanner.nextLine().split("");
        }
    }
}
