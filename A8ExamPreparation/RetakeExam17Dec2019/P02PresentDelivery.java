package A8ExamPreparation.RetakeExam17Dec2019;

import java.util.Scanner;

public class P02PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    public static int presents;
    private static boolean noMorePresents;
    private static int goodKidsCount;
    private static int goodKidsPresentsGiven;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                } else if (matrix[row][col].equals("V")) {
                    goodKidsCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    moveSanta(matrix, -1, 0);
                    break;
                case "down":
                    moveSanta(matrix, +1, 0);
                    break;
                case "left":
                    moveSanta(matrix, 0, -1);
                    break;
                case "right":
                    moveSanta(matrix, 0, +1);
                    break;
            }

            if (noMorePresents) {
                break;
            }

            command = scanner.nextLine();
        }

        if (noMorePresents) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        if (goodKidsCount == goodKidsPresentsGiven) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", goodKidsPresentsGiven);
        } else {
            System.out.printf("No presents for %d nice kid/s.", goodKidsCount - goodKidsPresentsGiven);
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void moveSanta(String[][] matrix, int rowMutator, int colMutator) {
        if (canMove(santaRow + rowMutator, santaCol + colMutator, matrix.length)) {
            matrix[santaRow][santaCol] = "-";
            santaRow += rowMutator;
            santaCol += colMutator;

            if (matrix[santaRow][santaCol].equals("V")) {
                presents--;
                goodKidsPresentsGiven++;
            } else if (matrix[santaRow][santaCol].equals("C")) {
                santaEatsACookie(matrix);
            }

            matrix[santaRow][santaCol] = "S";
            if (presents == 0) {
                noMorePresents = true;
            }
        }

    }

    private static boolean canMove(int santaRow, int santaCol, int length) {
        return santaRow >= 0 && santaRow < length && santaCol >= 0 && santaCol < length;
    }

    private static void santaEatsACookie(String[][] matrix) {
        if (matrix[santaRow][santaCol - 1].equals("V")) {
            matrix[santaRow][santaCol - 1] = "-";
            presents--;
            goodKidsPresentsGiven++;
        } else if (matrix[santaRow][santaCol - 1].equals("X")) {
            matrix[santaRow][santaCol - 1] = "-";
            presents--;
        }

        if (presents == 0) {
            return;
        }

        if (matrix[santaRow][santaCol + 1].equals("V")) {
            matrix[santaRow][santaCol + 1] = "-";
            presents--;
            goodKidsPresentsGiven++;
        } else if (matrix[santaRow][santaCol + 1].equals("X")) {
            matrix[santaRow][santaCol + 1] = "-";
            presents--;
        }
        if (presents == 0) {
            return;
        }
        if (matrix[santaRow - 1][santaCol].equals("V")) {
            matrix[santaRow - 1][santaCol] = "-";
            presents--;
            goodKidsPresentsGiven++;
        } else if (matrix[santaRow - 1][santaCol].equals("X")) {
            matrix[santaRow - 1][santaCol] = "-";
            presents--;
        }
        if (presents == 0) {
            return;
        }

        if (matrix[santaRow + 1][santaCol].equals("V")) {
            matrix[santaRow + 1][santaCol] = "-";
            presents--;
            goodKidsPresentsGiven++;
        } else if (matrix[santaRow + 1][santaCol].equals("X")) {
            matrix[santaRow + 1][santaCol] = "-";
            presents--;
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
