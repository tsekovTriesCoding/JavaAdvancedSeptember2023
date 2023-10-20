package A8ExamPreparation.RegularExam19February2022;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];
        fillMatrix(chessboard, scanner);

        int rowOfWhite = -1;
        int colOfWhite = -1;
        int rowOfBlack = -1;
        int colOfBlack = -1;
        for (int row = 0; row < chessboard.length; row++) {
            for (int col = 0; col < chessboard[row].length; col++) {
                if (chessboard[row][col].equals("w")) {
                    rowOfWhite = row;
                    colOfWhite = col;
                } else if (chessboard[row][col].equals("b")) {
                    rowOfBlack = row;
                    colOfBlack = col;
                }
            }
        }

        while (true) {
            if ((rowOfWhite - 1 >= 0 && colOfWhite - 1 >= 0) && chessboard[rowOfWhite - 1][colOfWhite - 1].equals("b")) {
                System.out.printf("Game over! White capture on %c%d.", colOfBlack + 'a', 8 - rowOfBlack);
                break;
            } else if ((rowOfWhite - 1 >= 0 && colOfWhite + 1 < 8) && chessboard[rowOfWhite - 1][colOfWhite + 1].equals("b")) {
                System.out.printf("Game over! White capture on %c%d.", colOfBlack + 'a', 8 - rowOfBlack);
                break;
            }

            chessboard[rowOfWhite][colOfWhite] = "-";
            rowOfWhite--;
            chessboard[rowOfWhite][colOfWhite] = "w";
            if (rowOfWhite == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %c%d.", colOfWhite + 'a', 8 - rowOfWhite);
                break;
            }

            if ((rowOfBlack + 1 < 8 && colOfBlack - 1 >= 0) && chessboard[rowOfBlack + 1][colOfBlack - 1].equals("w")) {
                System.out.printf("Game over! Black capture on %c%d.", colOfWhite + 'a', 8 - rowOfWhite);
                break;
            } else if ((rowOfBlack + 1 < 8 && colOfBlack + 1 < 8) && chessboard[rowOfBlack + 1][colOfBlack + 1].equals("w")) {
                System.out.printf("Game over! Black capture on %c%d.", colOfWhite + 'a', 8 - rowOfWhite);
                break;
            }

            chessboard[rowOfBlack][colOfBlack] = "-";
            rowOfBlack++;
            chessboard[rowOfBlack][colOfBlack] = "b";
            if (rowOfBlack == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.", colOfBlack + 'a', 8 - rowOfBlack);
                break;
            }

        }
    }

    private static void fillMatrix(String[][] chessboard, Scanner scanner) {
        for (int row = 0; row < chessboard.length; row++) {
            chessboard[row] = scanner.nextLine().split("");
        }
    }
}
