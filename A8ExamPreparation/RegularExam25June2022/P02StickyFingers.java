package A8ExamPreparation.RegularExam25June2022;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] field = new String[size][size];
        fillMatrix(field, scanner);

        int dillingerRow = -1;
        int dillingerCol = -1;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("D")) {
                    dillingerRow = row;
                    dillingerCol = col;
                }
            }
        }

        int totalMoneyStolen = 0;
        boolean caughtByPolice = false;
        for (String direction : directions) {
            int prevRow = dillingerRow;
            int prevCol = dillingerCol;
            if (direction.equals("up")) {
                dillingerRow--;
            } else if (direction.equals("down")) {
                dillingerRow++;
            } else if (direction.equals("left")) {
                dillingerCol--;
            } else if (direction.equals("right")) {
                dillingerCol++;
            }

            if (goesOutsideOfTheField(dillingerRow, dillingerCol, size)) {
                dillingerRow = prevRow;
                dillingerCol = prevCol;
                System.out.println("You cannot leave the town, there is police outside!");
            } else {
                field[prevRow][prevCol] = "+";
                if (field[dillingerRow][dillingerCol].equals("$")) {
                    field[dillingerRow][dillingerCol] = "D";
                    totalMoneyStolen += dillingerRow * dillingerCol;
                    System.out.printf("You successfully stole %d$.%n", dillingerRow * dillingerCol);
                } else if (field[dillingerRow][dillingerCol].equals("P")) {
                    field[dillingerRow][dillingerCol] = "#";
                    caughtByPolice = true;
                    break;
                } else {
                    field[dillingerRow][dillingerCol] = "D";
                }
            }

        }

        if (caughtByPolice) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoneyStolen);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoneyStolen);
        }
        printMatrix(field);
    }

    private static void printMatrix(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static boolean goesOutsideOfTheField(int dillingerRow, int dillingerCol, int size) {
        return dillingerRow < 0 || dillingerRow >= size || dillingerCol < 0 || dillingerCol >= size;
    }

    private static void fillMatrix(String[][] field, Scanner scanner) {

        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("\\s+");
        }
    }
}
