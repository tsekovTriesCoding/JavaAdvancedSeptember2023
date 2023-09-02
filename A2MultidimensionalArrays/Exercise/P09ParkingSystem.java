package A2MultidimentisionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ParkingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[0];

        boolean[][] matrix = new boolean[rows][cols];
        String input = scanner.nextLine();

        while (!input.equals("stop")) {

            int[] data = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int entryRow = data[0];
            int desiredRow = data[1];
            int desiredCol = data[2];

            int distance = Math.abs(entryRow - desiredRow) + desiredCol + 1;
            boolean spotFound = false;

            if (!matrix[desiredRow][desiredCol]) {
                spotFound = true;
                matrix[desiredRow][desiredCol] = true;
            }

            if (!spotFound) {

                int toLoopTo = Math.max(desiredCol, cols - desiredCol);
                for (int col = 1; col < toLoopTo; col++) {

                        if ((desiredCol - col > 0) && !matrix[desiredRow][desiredCol - col]) {
                            matrix[desiredRow][desiredCol - col] = true;
                            distance -= col;
                            spotFound = true;
                            break;
                        } else if ((desiredCol + col < cols) && !matrix[desiredRow][desiredCol + col]) {
                            matrix[desiredRow][desiredCol + col] = true;
                            distance += col;
                            spotFound = true;
                            break;
                        }
                    }

            }

            if (spotFound) {
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }

            input = scanner.nextLine();
        }
    }

}
