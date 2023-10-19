package A8ExamPreparation.Exam20February2021;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrixField = new String[size][size];
        fillMatrix(matrixField, scanner);

        int sapperRow = -1;
        int sapperCol = -1;
        int bombs = 0;
        for (int row = 0; row < matrixField.length; row++) {
            for (int col = 0; col < matrixField[row].length; col++) {
                if (matrixField[row][col].equals("s")) {
                    sapperRow = row;
                    sapperCol = col;
                } else if (matrixField[row][col].equals("B")) {
                    bombs++;
                }
            }
        }

        boolean endOfRoute = false;
        for (String direction : directions) {
            int prevRow = sapperRow;
            int prevCol = sapperCol;

            switch (direction) {
                case "up":
                    sapperRow--;
                    break;
                case "down":
                    sapperRow++;
                    break;
                case "left":
                    sapperCol--;
                    break;
                case "right":
                    sapperCol++;
                    break;
            }

            if (goesOutside(sapperRow, sapperCol, size)) {
                sapperRow = prevRow;
                sapperCol = prevCol;
            }
            matrixField[prevRow][prevCol] = "+";

            if (matrixField[sapperRow][sapperCol].equals("B")) {
                bombs--;
                matrixField[sapperRow][sapperCol] = "s";
                System.out.println("You found a bomb!");
            } else if (matrixField[sapperRow][sapperCol].equals("e")) {
                endOfRoute = true;
                break;
            }

            if (bombs == 0) {
                break;
            }

        }

        if (bombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endOfRoute) {
            System.out.printf("END! %d bombs left on the field", bombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sapperRow, sapperCol);
        }


    }

    private static void fillMatrix(String[][] matrixField, Scanner scanner) {
        for (int row = 0; row < matrixField.length; row++) {
            matrixField[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean goesOutside(int sapperRow, int sapperCol, int size) {
        return sapperRow < 0 || sapperRow >= size || sapperCol < 0 || sapperCol >= size;
    }
}


